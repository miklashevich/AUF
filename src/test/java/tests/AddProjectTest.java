package tests;

import baseEntities.BaseTest;
import core.BrowsersService;
import enums.ProjectType;
import models.Project;
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

        Project project = new Project();
        project.setName("AMiklashevich_9");
        project.setAnnouncement("Test MULTIPLE");
        project.setShowAnnouncement(true);
        project.setType(ProjectType.MULTIPLE);

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

        Project project = new Project();
        project.setName("AMiklashevich_10");
        project.setAnnouncement("Test SINGLE_WITH_BASELINE");
        project.setShowAnnouncement(true);
        project.setType(ProjectType.SINGLE_WITH_BASELINE);

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

        Project project = new Project();
        project.setName("AMiklashevich_11");
        project.setAnnouncement("Test SINGLE_FOR_ALL_CASES");
        project.setShowAnnouncement(true);
        project.setType(ProjectType.SINGLE_FOR_ALL_CASES);

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.addProject(project);


        OverviewPage overviewPage = new OverviewPage(browsersService, false);
        overviewPage.isPageOpened();
        Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully added the new project.");
    }

}
