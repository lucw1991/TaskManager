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




    public boolean addTask(String name) {

        // Track if added to keep duplicates out.
        boolean added = false;

        // Track if found
        boolean found = false;

        // Task object
        Task task = new Task(name);

        // Check if present already in the list.
        for (Task t : taskList) {
            // If present then break the look and continue.
            if (t.getName().equals(task.getName())) {
                found = true;
                break;
            }
        }

        // If not found, then add task to the list. If found, then print the message.
        if (!found) {
            taskList.add(task);
            added = true;
        } else {
            System.out.println("Task already exists!");
        }

        return added;

    }


    public boolean deleteTask(String name) {

        return taskList.removeIf(t ->
                        t.getName().equals(name));

    }


    public List<Task> getTasks() {
        return taskList;
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
