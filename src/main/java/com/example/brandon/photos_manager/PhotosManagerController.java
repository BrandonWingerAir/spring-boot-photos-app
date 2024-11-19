package com.example.brandon.photos_manager;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

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

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id) {
        PhotoModel photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photos")
    public PhotoModel create(@RequestBody @Valid PhotoModel photo) {
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
        return photo;
    }

}
