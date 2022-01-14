package com.codesoom.assignment.application;

import com.codesoom.assignment.TaskNotFoundException;
import com.codesoom.assignment.models.Task;

import java.util.*;

public class TaskService {
  private List<Task> tasks = new ArrayList();
  private Long newId = 0L;

  public List<Task> getTasks() {
    return tasks;
  }

  public Task getTask(Long id) {
    return tasks.stream()
        .filter(task -> task.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new TaskNotFoundException(id));
  }

  public Task createTask(Task task) {
    task.setId(generateId());
    tasks.add(task);

    return task;
  }

  private Long generateId() {
    newId += 1;
    return newId;
  }

  public void deleteTask(Long id) {
    Task task = getTask(id);
    tasks.remove(task);
  }

  public Task updateTask(Long id, Task source) {
    Task task = getTask(id);
    task.setTitle(source.getTitle());;

    return task;
  }
}
