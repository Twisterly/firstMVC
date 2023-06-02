package by.masha.cha.controllers;

import by.masha.cha.MysqlJdbcDataSource;
import by.masha.cha.dao.EmployeeDao;
import by.masha.cha.dao.ProjectDao;
import by.masha.cha.model.Employee;
import by.masha.cha.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectDao projectDAO;

    @Autowired
    public ProjectController(ProjectDao projectDao) {
        this.projectDAO = projectDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("project", projectDAO.index());
        return "project/index_project";
    }







}


