package day02;

import java.util.List;

public class Movie {
    private String title;
    private double length;
    private List<String> actors;

    public Movie(String title, double length, List<String> actors) {
        this.title = title;
        this.length = length;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public double getLength() {
        return length;
    }

    public List<String> getActors() {
        return actors;
    }
}
