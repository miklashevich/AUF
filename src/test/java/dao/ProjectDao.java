package dao;

import models.ProjectLombokBuilder;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {

     int add(ProjectLombokBuilder projectLombokBuilder) throws SQLException;

     ProjectLombokBuilder getProjectLombokBuilder(int id) throws SQLException;

     int delete(int id) throws SQLException;

     int update(ProjectLombokBuilder projectLombokBuilder) throws SQLException;

     List<ProjectLombokBuilder> getProject() throws SQLException;


     void drop() throws SQLException;

     void create() throws SQLException;
}
