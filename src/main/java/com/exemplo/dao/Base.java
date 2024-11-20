package com.exemplo.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter
@Data
public abstract class Base<T> {

    private Connection connection;
    private T t;

    public void post(){
        try {
            String sqlPost = "INSERT INTO";
            PreparedStatement statement = connection.prepareStatement(sqlPost);
            // statement.setString();
        }
        catch (SQLException err1){
            try {
                connection.rollback();
            }
            catch (SQLException err2){
                err2.printStackTrace();
            }

        }
    }

}
