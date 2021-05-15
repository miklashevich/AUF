package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import models.ProjectLombokBuilder;
import models.UserSimple;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.OverviewPage;
import steps.LoginSteps;
import steps.ProjectSteps;


public class LombokTest extends BaseTest {
    private Logger logger = LogManager.getLogger();

    @Test
    public void lombokTest(){
        UserSimple user = UserSimple.builder()
                .firstName("Test")
                .surName("Ertyui")
                .build();
        UserSimple user1 = UserSimple.builder()
                .firstName("Test1")
                .surName("Ertyui1")
                .build();


      //  System.out.println(user.getFirstName());
      //  System.out.println(user1.getSurName());
      //  logger.fatal("FATAL: все плохо фатальная ошибка");
       // logger.error("ERROR плохо но не все");
      //  logger.info("INFO: Просто что бы ты знал");
       // logger.debug("DEBUG: для отладки");
      //  logger.trace("TRACE: Абсолютно все");


    }
@Test
    public void ProjectLombokTest(){
    LoginSteps loginSteps = new LoginSteps(browsersService);
    DashboardPage dashboardPage = loginSteps
            .loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

    dashboardPage.getSidebarProjectsAddButton().click();

    ProjectLombokBuilder projectLombokBuilder = ProjectLombokBuilder.builder()
            .name("ProjectLombok_1")
            .announcement("Test add project with lombok builder")
            .isShowAnnouncement(true)
            .type(ProjectType.MULTIPLE)
            .build();

    ProjectSteps projectSteps = new ProjectSteps(browsersService);
    projectSteps.addProjectLombokBuilder(projectLombokBuilder);

    OverviewPage overviewPage = new OverviewPage(browsersService, false);
    overviewPage.isPageOpened();
    Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully added the new project.");


}
}
