package com.example.brandon.photos_manager;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotosManagerService {

    private Map<String, PhotoModel> db = new HashMap<>() {{
        put("1", new PhotoModel("1", "hello.jpg"));
    }};


    public Collection<PhotoModel> findAll() {
        return db.values();
    }

    public PhotoModel get(String id) {
        return db.get(id);
    }

    public PhotoModel remove(String id) {
        return db.remove(id);
    }

    public PhotoModel save(String filename, String contentType, byte[] data) {

        PhotoModel photo = new PhotoModel();

        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFilename(filename);
        photo.setData(data);

        db.put(photo.getId(), photo);

        return photo;

    }
}
