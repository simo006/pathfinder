package com.example.pathfinder.model.view;

import com.example.pathfinder.model.enums.LevelEnum;

import java.util.List;

public class RouteDetailsViewModel {

    private Long id;
    private String name;
    private String description;
    private String gpxCoordinates;
    private LevelEnum level;
    private String videoUrl;
    private List<PictureViewModel> pictures;
    private String authorName;

    public Long getId() {
        return id;
    }

    public RouteDetailsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteDetailsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteDetailsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteDetailsViewModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteDetailsViewModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteDetailsViewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public List<PictureViewModel> getPictures() {
        return pictures;
    }

    public RouteDetailsViewModel setPictures(List<PictureViewModel> pictures) {
        this.pictures = pictures;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public RouteDetailsViewModel setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }
}
