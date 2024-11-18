package com.example.brandon.photos_manager;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class PhotosManagerController {

    private Map<String, PhotoModel> db = new HashMap<>() {{
        put("1", new PhotoModel("1", "hello.jpg"));
    }};

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photos")
    public Collection<PhotoModel> get() {
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public PhotoModel get(@PathVariable String id) {
        PhotoModel photo = db.get(id);

        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return photo;
    }

}
