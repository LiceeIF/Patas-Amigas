package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import lombok.Data;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public abstract class Base<T> {

    private T t;
    private static Connection CONNECTION;

    static {
        try {
            CONNECTION = ConnectionFactory.getConnection();
            CONNECTION.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public Base( T t) {
        this.t = t;
    }


    public void post() throws SQLException, IllegalAccessException  {
        Field[] fields = t.getClass().getDeclaredFields();
        try (PreparedStatement statement = CONNECTION.prepareStatement(fazerInsert(fields))) {
            fazerStatements(statement, fields);
            CONNECTION.commit();
        } catch (SQLException err1) {
            CONNECTION.rollback();

            if (err1.getErrorCode() == 1062 || "23000".equals(err1.getSQLState())) {
                throw new SQLException("CPF ou email já cadastrado.", err1);
            }

            throw new SQLException("Erro durante a execução do SQL: " + err1.getMessage(), err1);
        }
    }


    public void delete() throws SQLException {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM " + t.getClass().getSimpleName() + " WHERE id=?")) {
            CONNECTION.setAutoCommit(false);
            Field idField = t.getClass().getDeclaredField("id");
            idField.setAccessible(true);

            Object idValue = idField.get(t);
            statement.setObject(1, idValue);

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                CONNECTION.commit();
            } else {
                throw new SQLException("Nada mudou, provavel que ID não exista.");
            }

        } catch (SQLException err1) {
            try {
                CONNECTION.rollback();
            } catch (SQLException err2) {
                throw new SQLException(err2);
            }
            throw err1;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public String fazerInsert(Field[] fields) {
       StringBuilder sqlQuery = new StringBuilder();
       sqlQuery.append("INSERT INTO ").append(t.getClass().getSimpleName()).append(" (");

       for (int i = 0; i < fields.length - 1; i++) {
           sqlQuery
                   .append(fields[i].getName())
                   .append(" ,");
       }
       sqlQuery
               .append(fields[fields.length - 1].getName())
               .append(" ) VALUES (");

       for (int i = 0; i < fields.length - 1; i++) {
           sqlQuery.append("? ,");
       }
       sqlQuery.append("? );");

       System.out.println(sqlQuery);
       return String.valueOf(sqlQuery);
   }


    public void fazerStatements(PreparedStatement statement, Field[]  fields) throws IllegalAccessException, SQLException {
        int i = 1;

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(t);

            if (value != null) {
                statement.setString(i, value.toString());
            } else {
                statement.setNull(i, java.sql.Types.VARCHAR);
            }
            i++;
        }
        statement.executeUpdate();

    }

}
