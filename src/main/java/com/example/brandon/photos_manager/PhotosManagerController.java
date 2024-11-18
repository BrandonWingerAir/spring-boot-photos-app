package com.example.brandon.photos_manager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PhotosManagerController {

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

}
