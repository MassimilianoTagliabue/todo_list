package org.lessons.java.todo_list.repository;

import org.lessons.java.todo_list.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer>{
    
}
