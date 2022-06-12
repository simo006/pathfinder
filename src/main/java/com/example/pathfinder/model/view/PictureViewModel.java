package com.example.pathfinder.model.view;

public class PictureViewModel {

    private String url;
    private String title;

    public String getUrl() {
        return url;
    }

    public PictureViewModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PictureViewModel setTitle(String title) {
        this.title = title;
        return this;
    }
}
