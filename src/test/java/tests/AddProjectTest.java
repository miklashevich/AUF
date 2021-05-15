package tests;

import baseEntities.BaseTest;
import core.BrowsersService;
import enums.ProjectType;
import models.Project;
import models.ProjectBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.OverviewPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class AddProjectTest extends BaseTest {

    @Test
    public void AddNewProjectTestMultiple() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getSidebarProjectsAddButton().click();

        ProjectBuilder project = new ProjectBuilder.Builder()
                .withName("A_Mik9")
                .withAnnouncement("Test builder MULTIPLE")
                .withIsShowAnnouncement(true)
                .withType(ProjectType.MULTIPLE)
                .build();

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.addProject(project);

        OverviewPage overviewPage = new OverviewPage(browsersService, false);
        overviewPage.isPageOpened();
        Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully added the new project.");

    }
    @Test
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
    @Test
    public void AddNewProjectTestSingleForAllCases() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");


        dashboardPage.getSidebarProjectsAddButton().click();
        ProjectBuilder project = new ProjectBuilder.Builder()
                .withName("A_Mik11")
                .withAnnouncement("Test builder Test SINGLE_FOR_ALL_CASES")
                .withIsShowAnnouncement(true)
                .withType(ProjectType.MULTIPLE)
                .build();

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.addProject(project);

        OverviewPage overviewPage = new OverviewPage(browsersService, false);
        overviewPage.isPageOpened();
        Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully added the new project.");



    }

}
