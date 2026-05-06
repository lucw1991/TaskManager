package models;

import enums.Status;


public class Task {

    private String name;
    private Status status;


    // Constructor
    public Task(String name) {
        this.name = name;
        this.status = Status.PENDING;
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
