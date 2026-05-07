package services;

import enums.Status;
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


    public String getTask(String name) {
        String task = null;
        boolean found = false;


        for (Task t : taskList) {
            if (t.getName().equals(name)) {
                task = t.getName();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Task not found!");
        }

        return task;
    }


    public void updateTask(String task, Status status) {

        // Track if found. Must be in function or else it will get declared false over and over for the loop.
        boolean found = false;

        // Iterate through list,
        for (Task t : taskList) {
            // checking task names,
            if (t.getName().equals(task)) {
                // If found, update status,
                t.setStatus(status);

                // update found,
                found = true;

                // break the loop.
                break;
            }
        }

        // Give an error if not found.
        if (!found){
            System.out.println("Task does not exist!");
        }

    }


    public void markComplete(String task) {
        updateTask(task, Status.COMPLETE);
    }

}
