package com.example.brandon.photos_manager;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {

    private final PhotosManagerService photosManagerService;

    public PhotoController(PhotosManagerService photosManagerService) {

        this.photosManagerService = photosManagerService;

    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {

        byte[] data = new byte[0];
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(data, headers, HttpStatus.OK);

    }

}
