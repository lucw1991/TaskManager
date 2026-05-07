package models;

import enums.Status;

/*
   This is the basic model for the Task object. It has two constructors. The Name of a task will not change as of the
   first iteration of this program, in its CLI form.
*/


public class Task {

    private String name;
    private Status status;


    // Constructors
    public Task(String name) {
        this.name = name;
        this.status = Status.PENDING;
    }

    public Task(String name, Status status) {
        this.name = name;
        this.status = status;
    }


    // Getters
    public String getName() {
        return this.name;
    }

    public Status getStatus() {
        return this.status;
    }

    // Setters
    public void setStatus(Status status) {
        this.status = status;
    }

}
