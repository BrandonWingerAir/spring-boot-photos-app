package com.example.brandon.photos_manager;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PhotoController {

    private final PhotosManagerService photosManagerService;

    public PhotoController(PhotosManagerService photosManagerService) {

        this.photosManagerService = photosManagerService;

    }

    @GetMapping("/photos/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {

        PhotoModel photo = photosManagerService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = photo.getData();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));

        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(photo.getFilename())
                .build();

        headers.setContentDisposition(build);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);

    }

}
