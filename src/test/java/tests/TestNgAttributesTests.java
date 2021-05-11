package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import models.Project;
import models.ProjectBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.OverviewPage;
import pages.ProjectsPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class TestNgAttributesTests extends BaseTest {

    @Test (priority = 1, timeOut = 5000L, description = "max время выполнения теста, если не успеет будет fail")
    public void LoginPositiveTest() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test (priority = 1, dependsOnMethods = "LoginPositiveTest")
    public void LoginTestWithIncorrectCredentials() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com", "qweqwe");

        Assert.assertEquals(loginPage.getErrorText(),
                "Email/Login or Password is incorrect. Please try again.");
    }
    @Test (priority = 2)
    public void LoginNegativeTest() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginNegativeTest();


        Assert.assertEquals(loginPage.isPageOpened(), true);

    }

    @Test (dependsOnMethods = "LoginTestWithIncorrectCredentials")
    public void AddNewProjectTestMultiple() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getSidebarProjectsAddButton().click();

        ProjectBuilder project = new ProjectBuilder.Builder()
                .withName("A_Mik9")
                .withAnnouncement("Test builder")
                .withIsShowAnnouncement(true)
                .withType(ProjectType.MULTIPLE)
                .build();

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.addProject(project);

        OverviewPage overviewPage = new OverviewPage(browsersService, false);
        overviewPage.isPageOpened();
        Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully added the new project.");


    }
    @Test (dependsOnMethods = "AddNewProjectTestMultiple")
    public void AddNewProjectTestSingleWithBaseline() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getSidebarProjectsAddButton().click();

        ProjectBuilder project = new ProjectBuilder.Builder()
                .withName("A_Mik10")
                .withAnnouncement("Test builder SINGLE_WITH_BASELINE")
                .withIsShowAnnouncement(true)
                .withType(ProjectType.MULTIPLE)
                .build();

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.addProject(project);

        OverviewPage overviewPage = new OverviewPage(browsersService, false);
        overviewPage.isPageOpened();
        Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully added the new project.");


    }
    @Test (dependsOnMethods = "AddNewProjectTestSingleWithBaseline")
    public void AddNewProjectTestSingleForAllCases() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getSidebarProjectsAddButton().click();

        ProjectBuilder project = new ProjectBuilder.Builder()
                .withName("A_Mik11")
                .withAnnouncement("Test builder SINGLE_FOR_ALL_CASES")
                .withIsShowAnnouncement(true)
                .withType(ProjectType.MULTIPLE)
                .build();

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.addProject(project);

        OverviewPage overviewPage = new OverviewPage(browsersService, false);
        overviewPage.isPageOpened();
        Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully added the new project.");


    }

    @Test (dependsOnMethods = "AddNewProjectTestSingleWithBaseline")
    public void updateProject() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        browsersService.getDriver().get("https://aqa04onl03.testrail.io/index.php?/admin/projects/overview");

        ProjectSteps projectSteps = new ProjectSteps(browsersService);


        Project project = new Project();

        projectSteps.UpdateProject("AMiklashevich_10");
        project.setAnnouncement("Added new announcement");

        ProjectsPage projectsPage = new ProjectsPage(browsersService,false);
        projectsPage.getAnnouncementInput().sendKeys(project.getAnnouncement());
        projectsPage.saveProjectButton().click();

        OverviewPage overviewPage = new OverviewPage(browsersService, false);
        overviewPage.isPageOpened();
        Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully updated the project.");

    }

    @Test (dependsOnMethods = "updateProject")
    public void delProject() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        browsersService.getDriver().get("https://aqa04onl03.testrail.io/index.php?/admin/projects/overview");

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.DeleteProject("AMiklashevich_10");

        OverviewPage overviewPage = new OverviewPage(browsersService, false);
        overviewPage.isPageOpened();
        Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully deleted the project.");

    }





}
