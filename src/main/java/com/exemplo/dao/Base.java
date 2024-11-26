package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import lombok.Data;

import java.lang.reflect.Field;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * Classe que os DAO vão herdar.
 *
 * @param <T>
 */
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


    public void post() throws SQLException, IllegalAccessException, NoSuchAlgorithmException, InvalidKeySpecException {
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
/*

    public void findById() throws SQLException {
        try(PreparedStatement statement = CONNECTION.prepareStatement("SELECT FROM" + t.getClass().getSimpleName() + " WHERE id=?")){
            Field idField = t.getClass().getDeclaredField("id");
            idField.setAccessible(true);

            Object idValue = idField.get(t);
            statement.setObject(1, idValue);

            ResultSet result= statement.executeQuery();



        }
        catch (SQLException | NoSuchFieldException | IllegalAccessException err){
            throw  new Error(err);
        }
    }
*/

    public void delete() throws SQLException {
        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM " + t.getClass().getSimpleName() + " WHERE id=?")) {
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


    protected String fazerInsert(Field[] fields) {
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


    protected void fazerStatements(PreparedStatement statement, Field[]  fields) throws IllegalAccessException, SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        int i = 1;

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(t);
            if (value != null) {

                if (field.getName().equals("senha")) {
                    statement.setString(i, hashSenha(value.toString()));

                } else {
                    statement.setString(i, value.toString());
                }
            } else{
                // Melhorar retornar erro
                statement.setNull(i, java.sql.Types.VARCHAR);
            }
            i++;
        }
        statement.executeUpdate();
        statement.close();
    }

    protected String hashSenha(String senha) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(senha.toCharArray(), salt, 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        byte[] hash = factory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }

}
