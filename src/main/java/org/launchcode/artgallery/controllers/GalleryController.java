package org.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@ResponseBody

public class GalleryController {

    @GetMapping("/")

    public String renderHomePage(){
        return "<h1>Welcome To The Art Gallery</h1>" +
                "<p>visit our <a href='/artworks'>collection</a> website</p>";

    }

}
