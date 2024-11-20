package com.example.brandon.photos_manager;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController

public class PhotosManagerController {

    private final PhotosManagerService photosManagerService;

    public PhotosManagerController(PhotosManagerService photosManagerService) {
        this.photosManagerService = photosManagerService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photos")
    public Collection<PhotoModel> get() {
        return photosManagerService.findAll();
    }

    @GetMapping("/photos/{id}")
    public PhotoModel get(@PathVariable String id) {

        PhotoModel photo = photosManagerService.get(id);

        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return photo;

    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id) {

        PhotoModel photo = photosManagerService.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/photos")
    public PhotoModel create(@RequestPart("data") MultipartFile file) throws IOException {

        return photosManagerService.save(file.getOriginalFilename(), file.getBytes());

    }

}
