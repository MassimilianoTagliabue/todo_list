package org.lessons.java.todo_list.service;

import java.util.List;

import org.lessons.java.todo_list.model.Task;
import org.lessons.java.todo_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }
}
