package tests.dbTests;

import dao.ProjectDaoImplementation;
import enums.ProjectType;
import enums.ProjectTypeBd;
import lombok.SneakyThrows;
import models.ProjectLombokBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import services.DataBaseConnection;
import services.JdbcService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlTest {
    Logger logger = LogManager.getLogger();
    int prNum = 1;

   // @Test
    public void connectionTest() {
        JdbcService jdbcService = new JdbcService();
        jdbcService.executeSQL("select * from customers");
        jdbcService.closeConnection();
    }


   // @Test
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
     @SneakyThrows
     @BeforeTest
     public  void setUp() {
         ProjectDaoImplementation prDao =  new ProjectDaoImplementation();

         prDao.drop();
         prDao.create();
     }



    @SneakyThrows
    @Test
    public void addTest(){
        ProjectDaoImplementation prDao =  new ProjectDaoImplementation();
        ProjectLombokBuilder project = ProjectLombokBuilder.builder()
                .name("PR05")
                .announcement("PR05 announecement")
                .isShowAnnouncement(true)
                .typeBd(ProjectTypeBd.MULTIPLE)
                .build();


        System.out.println(prDao.add(project));
        System.out.println(prDao.add(project));
    }

    @SneakyThrows
    @Test
    public void updateTest(){
        ProjectDaoImplementation prDao =  new ProjectDaoImplementation();

        ProjectLombokBuilder project = ProjectLombokBuilder.builder()
                .id(prNum)
                .name("PR05 UPD")
                .announcement("PR05 announecement UPD")
                .isShowAnnouncement(true)
                .typeBd(ProjectTypeBd.SINGLE_FOR_ALL_CASES)
                .build();

        System.out.println(prDao.update(project));

    }

    @SneakyThrows
    @Test
    public void getProjectTest(){
        ProjectDaoImplementation prDao =  new ProjectDaoImplementation();

        ProjectLombokBuilder projectLombokBuilder = prDao.getProjectLombokBuilder(prNum);
        System.out.println(projectLombokBuilder.toString());

    }

    @SneakyThrows
    @Test
    public void getProjectListTest(){
        ProjectDaoImplementation prDao =  new ProjectDaoImplementation();

        for (ProjectLombokBuilder pr: prDao.getProject()) {
            System.out.println(pr.toString());
        }

    }

    @SneakyThrows
    @Test
    public void delete(){
        ProjectDaoImplementation prDao =  new ProjectDaoImplementation();

        System.out.println(prDao.delete(prNum));

    }

    @AfterTest
    public  void tearDown() {
        DataBaseConnection.closeConnection();
        System.out.println("Connection has been closed.");
    }


}