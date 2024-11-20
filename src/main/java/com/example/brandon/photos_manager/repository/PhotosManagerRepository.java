package com.example.brandon.photos_manager.repository;

import com.example.brandon.photos_manager.model.PhotoModel;
import org.springframework.data.repository.CrudRepository;

public interface PhotosManagerRepository extends CrudRepository<PhotoModel, Integer> {



}
