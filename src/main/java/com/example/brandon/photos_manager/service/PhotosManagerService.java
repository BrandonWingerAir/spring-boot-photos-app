package com.example.brandon.photos_manager.service;

import com.example.brandon.photos_manager.model.PhotoModel;
import com.example.brandon.photos_manager.repository.PhotosManagerRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotosManagerService {

    private final PhotosManagerRepository photosManagerRepository;

    public PhotosManagerService(PhotosManagerRepository photosManagerRepository) {
        this.photosManagerRepository = photosManagerRepository;
    }

    public Iterable<PhotoModel> get() {
        return photosManagerRepository.findAll();
    }

    public PhotoModel get(Integer id) {
        return photosManagerRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photosManagerRepository.deleteById(id);
    }

    public PhotoModel save(String filename, String contentType, byte[] data) {

        PhotoModel photo = new PhotoModel();

        photo.setContentType(contentType);
        photo.setFilename(filename);
        photo.setData(data);

        photosManagerRepository.save(photo);

        return photo;

    }
}
