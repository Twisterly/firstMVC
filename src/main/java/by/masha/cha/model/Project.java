package by.masha.cha.model;

import java.util.List;

public class Project {

    public Integer id;

    public String name;


    public Project() {
    }

    public Project(Integer id, String name) {
        this.id = id;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
