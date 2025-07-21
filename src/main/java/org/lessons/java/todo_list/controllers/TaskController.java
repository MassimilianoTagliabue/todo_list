package org.lessons.java.todo_list.controllers;

import org.lessons.java.todo_list.model.Task;
import org.lessons.java.todo_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    //index
    @GetMapping("/task")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "/index";
    }


    //create
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("task", new Task());
        return "/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("task") Task formTask,
            BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return"create-or-edit";
        }

        taskService.createOrEdit(formTask);
        
        return "redirect:/task";
    }
    
    
    
}
