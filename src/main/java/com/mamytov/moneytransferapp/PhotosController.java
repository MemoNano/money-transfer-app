package com.mamytov.moneytransferapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhotosController {

    @RequestMapping(value = "/api/photos/{id}", method = RequestMethod.GET)
    public Photo findOne(@PathVariable Long id){
        return new Photo(id, "Photo Name MEmo");
    }


    @PostMapping(value = "api/photos")
    @ResponseStatus(HttpStatus.CREATED)
    public Photo create(){

        return new Photo(1L, " New Photo");
    }
    @DeleteMapping(value = "api/photos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(){

        //TODO: Delete photos
    }

}
