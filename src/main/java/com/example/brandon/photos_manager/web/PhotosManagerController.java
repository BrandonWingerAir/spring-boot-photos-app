package com.example.brandon.photos_manager.web;

import com.example.brandon.photos_manager.model.PhotoModel;
import com.example.brandon.photos_manager.service.PhotosManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotosManagerController {

    private final PhotosManagerService photosManagerService;

    public PhotosManagerController(PhotosManagerService photosManagerService) {
        this.photosManagerService = photosManagerService;
    }

    @GetMapping("/")
    public String hello() {
        return "Photo Manager";
    }

    @GetMapping("/photos")
    public Iterable<PhotoModel> get() {
        return photosManagerService.get();
    }

    @GetMapping("/photos/{id}")
    public PhotoModel get(@PathVariable Integer id) {

        PhotoModel photo = photosManagerService.get(id);

        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return photo;

    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id) {
        photosManagerService.remove(id);
    }

    @PostMapping("/photos")
    public PhotoModel create(@RequestPart("data") MultipartFile file) throws IOException {
        return photosManagerService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }

}
