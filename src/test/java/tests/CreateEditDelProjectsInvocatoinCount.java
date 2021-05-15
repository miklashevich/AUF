package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import models.Project;
import models.ProjectBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.OverviewPage;
import pages.ProjectsPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class CreateEditDelProjectsInvocatoinCount extends BaseTest {


    @Test (invocationCount = 3)
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
    @Test (invocationCount = 2)
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

        dashboardPage.getSidebarProjectsAddButton().click();


    }
    @Test (invocationCount = 2)
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

        dashboardPage.getSidebarProjectsAddButton().click();


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



    @Test (invocationCount = 2)
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
