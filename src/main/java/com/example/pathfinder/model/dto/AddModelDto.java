package com.example.pathfinder.model.dto;

import com.example.pathfinder.model.enums.CategoryEnum;
import com.example.pathfinder.model.enums.LevelEnum;
import com.example.pathfinder.web.annotation.LettersDigitsAndSpaces;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddModelDto {

    @NotBlank
    @LettersDigitsAndSpaces
    @Size(min = 5, max = 20)
    private String name;

    @NotBlank
    @Size(min = 5)
    private String description;

    @NotNull
    private MultipartFile gpxCoordinates;

    @NotNull
    private LevelEnum level;

    @NotBlank
    private String videoUrl;

    @NotNull
    private CategoryEnum[] categories;

    public String getName() {
        return name;
    }

    public AddModelDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddModelDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public AddModelDto setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public AddModelDto setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public AddModelDto setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public CategoryEnum[] getCategories() {
        return categories;
    }

    public AddModelDto setCategories(CategoryEnum[] categories) {
        this.categories = categories;
        return this;
    }
}
