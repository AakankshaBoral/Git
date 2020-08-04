package com.example.todolist_app;

public class Task
{
    int id;

    public Task(int id, String task, String timestamp) {
        this.id = id;
        this.task = task;
        this.timestamp = timestamp;
    }

    String task;
    String timestamp;

    public Task() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }




}
