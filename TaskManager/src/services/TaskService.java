package services;

import models.Task;

import java.util.ArrayList;
import java.util.List;

/*
   This file can be thought of as the gatekeeper to the data for now. It owns the list and is the
   only class allowed to touch it directly. Any operation that reads or changes the list goes through here.

   This holds the functions for any CRUD operations.
*/


public class TaskService {

    // Array list to store created tasks.
    private final List<Task> taskList = new ArrayList<>();

    public void addTask(String name) {
        Task task = new Task(name);

        taskList.add(task);
    }

    public List<Task> getTasks() {
        return taskList;
    }

}
