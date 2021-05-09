package tests;

import baseEntities.BaseTest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.OverviewPage;
import pages.ProjectsPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class ProjectTests extends BaseTest {



    @Test
    public void updateProject() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        browsersService.getDriver().get("https://aqa04onl03.testrail.io/index.php?/admin/projects/overview");

        Project project = new Project();
        project.setAnnouncement("Added new announcement");

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.UpdateProject("AMiklashevich_10");

        ProjectsPage projectsPage = new ProjectsPage(browsersService,false);
        projectsPage.getAnnouncementInput().sendKeys(project.getAnnouncement());
        projectsPage.saveProjectButton().click();

        OverviewPage overviewPage = new OverviewPage(browsersService, false);
        overviewPage.isPageOpened();
        Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully updated the project.");

    }



    @Test (invocationCount = 9)
    public void delProject() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        browsersService.getDriver().get("https://aqa04onl03.testrail.io/index.php?/admin/projects/overview");

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.DeleteProject("AMiklashevich_9");

        OverviewPage overviewPage = new OverviewPage(browsersService, false);
        overviewPage.isPageOpened();
       Assert.assertEquals(overviewPage.getMessageSuccess(), "Successfully deleted the project.");

    }


}

