package models;

import enums.ProjectType;

public class ProjectBuilder {
    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    private ProjectType type;

    public String getName() {
        return name;
    }
    public String getAnnouncement() {
        return announcement;
    }
    public ProjectType getType() {
        return type;
    }

    public boolean isShowAnnouncement() {
        return isShowAnnouncement;
    }

    public static class Builder {
        private ProjectBuilder projectBuilder;

        public Builder(){
            projectBuilder = new ProjectBuilder();
        }

        public ProjectBuilder build(){
            return projectBuilder;
        }


        public Builder withName(String name){
            projectBuilder.name = name;
            return this;
        }



        public Builder withAnnouncement(String announcement){
            projectBuilder.announcement = announcement;
            return this;
        }

        public Builder withIsShowAnnouncement(boolean showAnnouncement){
            projectBuilder.isShowAnnouncement = showAnnouncement;
            return this;
        }
        public Builder withType(ProjectType type){
            projectBuilder.type = type;
            return this;
        }
    }
}
