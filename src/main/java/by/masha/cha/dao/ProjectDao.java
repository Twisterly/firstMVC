package by.masha.cha.dao;

import by.masha.cha.MysqlJdbcDataSource;
import by.masha.cha.model.Employee;
import by.masha.cha.model.JobTitle;
import by.masha.cha.model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProjectDao {

    public Connection connection = new MysqlJdbcDataSource().getConnection();

    public List<Project> index() {

        List<Project> projects = new ArrayList<>();
        try {
            Statement statement =
                    connection.createStatement();
            java.lang.String SQL = ("SELECT * FROM projects WHERE project_id=1");
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("project_id"));
                project.setId(resultSet.getInt("project_name"));

               projects.add(project);
            }
        } catch (SQLException e) {
            System.out.println("We caught it: " + e.getMessage());
        }

        return projects;
    }


}
