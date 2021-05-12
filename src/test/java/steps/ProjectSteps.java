package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import enums.ProjectType;
import models.Project;
import models.ProjectBuilder;
import models.ProjectLombokBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddProjectPage;
import pages.OverviewPage;
import pages.ProjectsPage;

public class ProjectSteps extends BaseStep {

    public ProjectSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public OverviewPage addProjectLombokBuilder (ProjectLombokBuilder projectLombokBuilder) {
        AddProjectPage addProjectPage = new AddProjectPage(browsersService, false);
        addProjectPage.getNameInput().sendKeys(projectLombokBuilder.getName());
        addProjectPage.getAnnouncementInput().sendKeys(projectLombokBuilder.getAnnouncement());
        if (projectLombokBuilder. isShowAnnouncement()) addProjectPage.IsShowAnnouncementInput().click();

        if(projectLombokBuilder.getType().toString().equals("SINGLE_FOR_ALL_CASES")) addProjectPage.suite_mode_singleInput().click();
        if(projectLombokBuilder.getType().toString().equals("SINGLE_WITH_BASELINE"))addProjectPage.suite_mode_single_baselineInput().click();
        if(projectLombokBuilder.getType().toString().equals("MULTIPLE")) addProjectPage.suite_mode_multiInput().click();

        addProjectPage.addProjectButton().click();

        return new OverviewPage(browsersService, false);


    }

    public OverviewPage addProject (ProjectBuilder projectBuilder) {
        AddProjectPage addProjectPage = new AddProjectPage(browsersService, false);
        addProjectPage.getNameInput().sendKeys(projectBuilder.getName());
        addProjectPage.getAnnouncementInput().sendKeys(projectBuilder.getAnnouncement());
        if (projectBuilder. isShowAnnouncement()) addProjectPage.IsShowAnnouncementInput().click();

        if(projectBuilder.getType().toString().equals("SINGLE_FOR_ALL_CASES")) addProjectPage.suite_mode_singleInput().click();
        if(projectBuilder.getType().toString().equals("SINGLE_WITH_BASELINE"))addProjectPage.suite_mode_single_baselineInput().click();
        if(projectBuilder.getType().toString().equals("MULTIPLE")) addProjectPage.suite_mode_multiInput().click();

        addProjectPage.addProjectButton().click();

        return new OverviewPage(browsersService, false);


    }


    public OverviewPage UpdateProject(String projectName) {
        ProjectsPage projectsPage = new ProjectsPage(browsersService, false);
        WebElement rowElement = projectsPage.getRowForElementInTable(projectName);
        rowElement.findElement(By.className("icon-small-edit")).click();


        projectsPage.saveProjectButton().click();


        return new OverviewPage(browsersService, false);


    }

    public OverviewPage DeleteProject(String projectName) {
        ProjectsPage projectsPage = new ProjectsPage(browsersService, false);
        projectsPage.getDeleteIconForElementInTable(projectName).click();
        projectsPage.getCheckbox().click();
        projectsPage.buttonOk().click();


       return new OverviewPage(browsersService, false);



    }
}
