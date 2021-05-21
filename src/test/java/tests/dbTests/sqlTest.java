package tests.dbTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import services.JdbcService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlTest {
    Logger logger = LogManager.getLogger();

    @Test
    public void connectionTest() {
        JdbcService jdbcService = new JdbcService();
        jdbcService.executeSQL("select * from customers");
        jdbcService.closeConnection();
    }


    @Test
    public void connectionTest2() throws SQLException {
        JdbcService jdbcService = new JdbcService();
        ResultSet resultSet = jdbcService.executeQuery("select * from customers");

        while (resultSet.next()) {
        String id = resultSet.getString("id");
        String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString(3);
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");

            logger.info("Result: id = " + id + ", firstname = " + firstname + ", lastname = " + lastname + ", email = " + email + ", age = " + age);

        }
        jdbcService.closeConnection();
    }
}