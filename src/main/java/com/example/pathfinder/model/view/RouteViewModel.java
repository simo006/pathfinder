package com.example.pathfinder.model.view;

public class RouteViewModel {

    private Long id;
    private String name;
    private String description;
    private PictureViewModel picture;

    public Long getId() {
        return id;
    }

    public RouteViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public PictureViewModel getPicture() {
        return picture;
    }

    public RouteViewModel setPicture(PictureViewModel picture) {
        this.picture = picture;
        return this;
    }
}
