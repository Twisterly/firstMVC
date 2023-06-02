package by.masha.cha.controllers;

import by.masha.cha.dao.JobTitleDao;
import by.masha.cha.model.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/job-title")
public class JobTitleController {

    private final JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleController(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("jobTitle", jobTitleDao.index());
        return "job-title/index_jobTitle";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("jobTitle", jobTitleDao.getById(id));
        return "job-title/show_jobTitle";
    }


    @GetMapping("/new")
    public String newJobTitle(@ModelAttribute("jobTitle") JobTitle jobTitle) {
        return "job-title/new_jobTitle";
    }


    @PostMapping()
    public String create(@ModelAttribute("jobTitle") JobTitle jobTitle) {

        jobTitleDao.save(jobTitle);
        return "redirect:/job-title";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("jobTitle", jobTitleDao.getById(id));
        return "job-title/edit_jobTitle";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("jobTitle") JobTitle jobTitle, BindingResult bindingResult,
                         @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors())
            return "job-title/edit_jobTitle";

        jobTitleDao.update(id, jobTitle);
        return "redirect:/job-title";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        jobTitleDao.delete(id);
        return "redirect:/job-title";
    }
}



