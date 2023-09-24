package org.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/artworks")
@ResponseBody

public class ArtWorkController {

    private static int nextId = 6;
    private static final Map<Integer,String> artWorks = new HashMap<>(){{
        put(1, "Girl With a Pearl Earring");
        put(2, "Mona Lisa");
        put(3, "The Birth of Venus");
        put(4, "The persistence of Memory");
        put(5, "The Starry Night");
    }};

    @GetMapping("")

    public String renderArtworksPage(){
        StringBuilder artWorkList = new StringBuilder();
        for(int artWorkId : artWorks.keySet()){
            String artWork = artWorks.get(artWorkId);
            artWorkList.append("<li><a href ='/artworks/details/").append(artWorkId).append("'>").append(artWork).append("</a>").append("</li>");
        }
        return "<html>" +
                "<body>" +
                "<h2>ARTWORKS</h2>" +
                "<ul>" +
                artWorkList +
                "</ul>" +
                "<p>Click <a href ='/artworks/add'>here</a> to add another artwork</p>" +
                "</body>" +
                "</html>";
    }
    @GetMapping("/add")

    public String displayArtWorkForm(){
        return "<html>" +
                "<body>" +
                "<form action = '/artworks/add' method= 'POST'>" +
                "<p> enter the name of the new artwork</p>"+
                "<input type='text' name='artwork'/>" +
                "<button type='submit'> submit</button>"+
                "</form>" +
                "</body>" +
                "</html>";

    };

    @PostMapping("/add")

    public String addArtWork(@RequestParam String artwork){
        artWorks.put(nextId, artwork);
        nextId++;
        return "<html>" +
                "<body>" +
                "<h3>ARTWORKS ADDED</h3>" +
                "<p> successful " + artwork + " added to the collection</p>"+
                "<p>Click <a href ='/artworks/add'>here</a> to add another artwork or <a href ='/artworks'>view the list</a></p>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("/details/{artWorkId}")

    public String displayArtWorkDetails(@PathVariable int artWorkId){
        return "<html>" +
                "<body>" +
                "<h3>ARTWORK</h3>" +
                "<p><b>ID:</b> " + artWorkId + "</p>"+
                "<p><b>Name:</b>" + artWorks.get(artWorkId)+ "</p>" +
                "</body>" +
                "</html>";
    }
}
