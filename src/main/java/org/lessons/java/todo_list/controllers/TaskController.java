package org.lessons.java.todo_list.controllers;

import org.lessons.java.todo_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @GetMapping("/lista")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "/index";
    }
    
}
