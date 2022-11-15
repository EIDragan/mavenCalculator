package com.endava.google;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class DbConnection {

    private static final Logger LOGGER = LogManager.getLogger(GsonExample.class);

    public static void main(String[] args) throws SQLException {


        //conexiune cu baza de date
        Connection conn = DriverManager.getConnection("jdbc:mysql://bhdtest.endava.com:3306/petclinic", "root", "root");


        Statement statement = conn.createStatement();
        //ResultSet mapeaza o tabela
        ResultSet resultSet = statement.executeQuery("SELECT id,first_name FROM owners WHERE id = 5");


        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");


            LOGGER.info("{} {}", id, firstName);
        }


        LOGGER.info(resultSet);

    }
}
