package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;
import lombok.Builder;
import lombok.Data;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public abstract class Base<T> {

    private Connection connection;
    private T t;

    public Base(Connection connection, T t) {
        this.connection = connection;
        this.t = t;
    }

    public void post() {
        Field[] fields = t.getClass().getDeclaredFields();
        try (PreparedStatement statement = connection.prepareStatement(fazerInsert(fields))) {
            fazerStatements(statement, fields);
        } catch (SQLException err1) {
            try {
                connection.rollback();
                System.err.println("Erro durante a execução do SQL: " + err1.getMessage());
            } catch (SQLException err2) {
                System.err.println("Erro ao fazer rollback: " + err2.getMessage());
            }
        } catch (IllegalAccessException e) {
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
