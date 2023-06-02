package by.masha.cha.model;

public class JobTitle {

    public Integer id;

    public String jobTitle;

    public JobTitle() {
    }

    public JobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
