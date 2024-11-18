package com.example.brandon.photos_manager;

public class PhotoModel {

    private String id;

    private String filename;

    public PhotoModel() {

    }

    public PhotoModel(String id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    // TODO:
    // Raw Data

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
