package org.nhnacademy.airticket_reservation_system;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtils {
    private static final DataSource DATA_SOURCE;

    private DBUtils() {

    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return DATA_SOURCE;
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/module06");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("msluvy");
        basicDataSource.setInitialSize(10);
        basicDataSource.setMaxTotal(10);

        DATA_SOURCE = basicDataSource;
    }
}
