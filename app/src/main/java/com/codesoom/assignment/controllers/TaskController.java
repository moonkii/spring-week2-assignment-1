package com.codesoom.assignment.controllers;

import com.codesoom.assignment.application.TaskService;
import com.codesoom.assignment.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {
  private TaskService taskService;

  public TaskController() {
    this.taskService = new TaskService();
  }

  @GetMapping
  public List<Task> list() {
    return taskService.getTasks();
  }

  @GetMapping("{id}")
  public Task detail(@PathVariable Long id) {
    return taskService.getTask(id);
  }

  @PutMapping("{id}")
  public Task update(@PathVariable Long id, @RequestBody Task source) {
    return taskService.updateTask(id, source);
  }

  @PatchMapping("{id}")
  public Task patch(@PathVariable Long id, @RequestBody Task source) {
    return taskService.updateTask(id, source);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    taskService.deleteTask(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Task create(@RequestBody Task task) {
    return taskService.createTask(task);
  }
}
