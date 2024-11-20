package com.example.brandon.photos_manager;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class PhotoModel {

    private String id;

    @NotEmpty
    private String filename;

    private String contentType;

    @JsonIgnore
    private byte[] data;

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

    public byte[] getData() {
        return data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
