package com.example.lifegreenproject;

public class Gift {
    private String title;
    private String description;
    private int points;

    public Gift(String title, String description, int points) {
        this.title = title;
        this.description = description;
        this.points = points;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPoints() {
        return points;
    }
}

