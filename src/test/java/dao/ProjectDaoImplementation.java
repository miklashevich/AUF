package dao;

import enums.ProjectType;
import enums.ProjectTypeBd;
import models.Project;
import models.ProjectLombokBuilder;
import services.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImplementation implements ProjectDao {

    static Connection con = DataBaseConnection.getConnection();

    @Override
    public int add(ProjectLombokBuilder projectLombokBuilder) throws SQLException {
        String query = "INSERT INTO project (name, announcement, show_announcement, type ) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, projectLombokBuilder.getName());
        ps.setString(2, projectLombokBuilder.getAnnouncement());
        ps.setBoolean(3, projectLombokBuilder.isShowAnnouncement());
        ps.setInt(4, projectLombokBuilder.getTypeBd().getValue());

        return ps.executeUpdate();
    }

    @Override
    public ProjectLombokBuilder getProjectLombokBuilder(int id) throws SQLException {
        String query = "select * from project where id = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        boolean check = false;
        ProjectLombokBuilder projectLombokBuilder = ProjectLombokBuilder.builder().build();

        while (rs.next()) {
            check = true;
            projectLombokBuilder.setId(rs.getInt("id"));
            projectLombokBuilder.setName(rs.getString("name"));
            projectLombokBuilder.setAnnouncement(rs.getString("announcement"));
            projectLombokBuilder.setShowAnnouncement(rs.getBoolean("show_announcement"));
            projectLombokBuilder.setTypeBd(ProjectTypeBd.getEnumValue(rs.getInt("type")));

        }
        return check ? projectLombokBuilder : null;

    }

    @Override
    public int delete(int id) throws SQLException {
        String query = "DELETE FROM project WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int result = ps.executeUpdate();

        if (result > 0) {
            return result;
        } else {
            throw new SQLException();
        }
    }

    @Override
    public int update(ProjectLombokBuilder projectLombokBuilder) throws SQLException {

        String query = "UPDATE project SET name = ?, announcement = ?, show_announcement = ?, type = ? WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, projectLombokBuilder.getName());
        ps.setString(2, projectLombokBuilder.getAnnouncement());
        ps.setBoolean(3, projectLombokBuilder.isShowAnnouncement());
        ps.setInt(4, projectLombokBuilder.getTypeBd().getValue());
        ps.setInt(5, projectLombokBuilder.getId());

        return ps.executeUpdate();

    }

    @Override
    public List<ProjectLombokBuilder> getProject() throws SQLException {
        String query = "select * from project";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<ProjectLombokBuilder> projectList = new ArrayList<>();


        while (rs.next()) {
            ProjectLombokBuilder project = ProjectLombokBuilder.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .announcement(rs.getString("announcement"))
                    //.isShowAnnouncement(rs.getBoolean("show announcement"))
                    .typeBd(ProjectTypeBd.getEnumValue(rs.getInt("type")))
                    .build();
            projectList.add(project);
        }

        return projectList;
    }

    @Override
    public void drop() throws SQLException {
        String query = "drop table if exists project cascade;";
        PreparedStatement ps = con.prepareStatement(query);
        ps.execute();
    }

    @Override
    public void create() throws SQLException {
        String query = "create table project\n" +
                "(\n" +
                "    id                serial not null\n" +
                "        constraint project_pk\n" +
                "            primary key,\n" +
                "    name              varchar,\n" +
                "    announcement      varchar,\n" +
                "    show_announcement boolean,\n" +
                "    type              integer\n" +
                ");\n" +
                "\n" +
                "alter table project\n" +
                "    owner to postgres;\n" +
                "\n" +
                "create unique index project_id_uindex\n" +
                "    on project (id);";

        PreparedStatement ps = con.prepareStatement(query);
        ps.execute();
    }
}
