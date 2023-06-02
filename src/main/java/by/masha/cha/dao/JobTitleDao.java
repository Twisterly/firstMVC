package by.masha.cha.dao;

import by.masha.cha.MysqlJdbcDataSource;
import by.masha.cha.model.Employee;
import by.masha.cha.model.JobTitle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class JobTitleDao {

    public Connection connection = new MysqlJdbcDataSource().getConnection();

    public List<JobTitle> index() {

        List<JobTitle> jobTitles = new ArrayList<>();
        try {
            Statement statement =
                    connection.createStatement();
            String SQL = "SELECT * FROM job_title";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                JobTitle jobTitle = new JobTitle();
                jobTitle.setId(resultSet.getInt("id"));
                jobTitle.setJobTitle(resultSet.getString("job_title_name"));

                jobTitles.add(jobTitle);
            }
        } catch (SQLException e) {
            System.out.println("We caught it: " + e.getMessage());
        }

        return jobTitles;


    }

    public void save(JobTitle jobTitle) {

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "INSERT INTO job_title VALUES (?)");

            preparedStatement.setString(1, jobTitle.getJobTitle());

            preparedStatement.executeUpdate();
            connection.commit();
            connection.close();


        } catch (SQLException e) {
            System.out.println("We caught it: " + e.getMessage());
            throw new RuntimeException(e);//можно убрать
        }


    }

    public JobTitle getById(Integer id) {

        JobTitle jobTitle = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "SELECT * FROM job_title WHERE id = ? ");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            jobTitle = new JobTitle();
            jobTitle.setId(resultSet.getInt("id"));
            jobTitle.setJobTitle(resultSet.getString("job_title_name"));
        } catch (SQLException e) {
            System.out.println("We caught it: " + e.getMessage());
        }
        return jobTitle;
    }

    public void update(Integer id, JobTitle updatedJobTitle) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "UPDATE job_title SET id=?, job_title_name=? " +
                                    "WHERE id=?"
                    );

            preparedStatement.setInt(1, updatedJobTitle.getId());
            preparedStatement.setString(2, updatedJobTitle.getJobTitle());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("We caught it: " + e.getMessage());
        }
    }

    public void delete(Integer id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "DELETE FROM job_title WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("We caught it: " + e.getMessage());
        }
    }
}




