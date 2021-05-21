package services;

import org.testng.log4testng.Logger;

import java.sql.*;

public class JdbcService {
   static Logger logger = Logger.getLogger(JdbcService.class);

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USERNAME = "postgres";
    static final String PSW = "12345678";

    Connection connection = null;
    Statement statement = null;

    public JdbcService() {
        logger.info("Setup connection to Postgres DB");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error("Postgres JDBC Driver is not found.");
            logger.error(e.getMessage());
            return;
        }
        try {
          connection = DriverManager.getConnection(DB_URL, USERNAME, PSW);
        } catch (SQLException e) {
            logger.error("Connection is failed.");
            logger.error(e.getMessage());
            return;
        }

       if (connection != null)  {
           logger.info("You successfully connected to Data Base");
       } else {
           logger.info("Failed to connect to Data Base");
       }
    }

    public  Connection getConnection() {
        return connection;
    }

public Statement getStatement() {
    try {
        if (statement == null) {
                statement = connection.createStatement();
            }
            } catch (SQLException ex) {
        logger.error("Не удалось создать statement");
        logger.error(ex.getMessage());
        }
    return statement;
}

public void executeSQL(String sql){
    try {
        getStatement().execute(sql);
    }
    catch (SQLException ex) {
        logger.error((ex.getMessage()));
    }
}

    public ResultSet executeQuery(String sql){
        ResultSet resultSet = null;
        try {
            resultSet = getStatement().executeQuery(sql);
            logger.info("SQL: " + sql + " has been executed");
        }
        catch (SQLException ex) {
            logger.error((ex.getMessage()));
        }
        return resultSet;
    }


public void closeStatement(){
    try {
        statement.close();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}

    public void closeConnection() {
        try {
            connection.close();
            logger.info("The connection has been closed.");
        } catch (SQLException throwables) {
            logger.error("Could not close the connection");
            logger.error(throwables.getMessage());
        }
    }
}
