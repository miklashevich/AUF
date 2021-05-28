package models;

import enums.ProjectType;
import enums.ProjectTypeBd;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class ProjectLombokBuilder {
     int id;
     String name;
     String announcement;
     boolean isShowAnnouncement;
     ProjectType type;
     ProjectTypeBd typeBd;


}
