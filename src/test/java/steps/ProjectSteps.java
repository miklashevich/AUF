package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.Project;

public class ProjectSteps extends BaseStep {

    public ProjectSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public void AddProject(Project project) {
        System.out.println(project.getName());
        System.out.println(project.getAnnouncement());
        System.out.println(project.isShowAnnouncement());
        System.out.println(project.getType());
    }

    public void UpdateProject(Project project) {

    }

    public void DeleteProject(Project project) {

    }
}
