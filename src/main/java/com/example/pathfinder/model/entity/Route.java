package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.LevelEnum;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Column
    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private User author;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @ManyToMany
    @JoinTable(name = "routes_categories",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "route")
    private List<Picture> pictures;

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public Route setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Route setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Route setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public Route setPictures(List<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
