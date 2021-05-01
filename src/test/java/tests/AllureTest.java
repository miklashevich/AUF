package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import io.qameta.allure.*;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.OverviewPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class AllureTest extends BaseTest {

    @Epic("Main Epic")
    @Feature("Feature 1")
    @Story("Story 1")
    @Test (description = "Тестируем логирование в систему")
    @Description("Проверка с корректными данными")
    @TmsLink("659")
    @Link(name = "Test link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("A-5677RQ")
    @Severity(SeverityLevel.BLOCKER)

    public void loginTest () {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }
    @Epics(value = {@Epic("Main Epic"), @Epic("Second Epic")})
    @Features(value = {@Feature("Feature 1"),@Feature("Feature 2")})
    @Stories(value = {@Story("Story 1"), @Story("Story 2")})
    @Test (description = "Тест добавления проекта в систему")
    @Description("Проверка добавления проекта с типом Multiple в систему, позитивный тест - вводим корректные данные")
    @Severity(SeverityLevel.CRITICAL)
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
}
