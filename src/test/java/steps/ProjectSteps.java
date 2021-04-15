package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import enums.ProjectType;
import models.Project;
import pages.AddProjectPage;
import pages.OverviewPage;

public class ProjectSteps extends BaseStep {

    public ProjectSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public OverviewPage addProject (Project project) {
   AddProjectPage addProjectPage = new AddProjectPage(browsersService, false);
        addProjectPage.getNameInput().sendKeys(project.getName());
        addProjectPage.getAnnouncementInput().sendKeys(project.getAnnouncement());
        if (project.isShowAnnouncement()) addProjectPage.IsShowAnnouncementInput().click();

        if(project.getType().toString().equals("SINGLE_FOR_ALL_CASES")) addProjectPage.suite_mode_singleInput().click();
        if(project.getType().toString().equals("SINGLE_WITH_BASELINE"))addProjectPage.suite_mode_single_baselineInput().click();
        if(project.getType().toString().equals("MULTIPLE")) addProjectPage.suite_mode_multiInput().click();

        addProjectPage.addProjectButton().click();

       return new OverviewPage(browsersService, false);


        // зайти на страницу
        // заполнить форму
        // сохранить запись


    }

    public void UpdateProject(Project project) {

    }

    public void DeleteProject(Project project) {

    }
}
