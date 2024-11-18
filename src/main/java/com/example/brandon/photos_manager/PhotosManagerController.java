package com.example.brandon.photos_manager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class PhotosManagerController {

    private List<PhotoModel> db = List.of(new PhotoModel("1", "hello.jpg"));

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photos")
    public List<PhotoModel> get() {
        return db;
    }

}
