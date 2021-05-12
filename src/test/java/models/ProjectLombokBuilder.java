package models;

import enums.ProjectType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectLombokBuilder {
     String name;
     String announcement;
     boolean isShowAnnouncement;
     ProjectType type;


}
