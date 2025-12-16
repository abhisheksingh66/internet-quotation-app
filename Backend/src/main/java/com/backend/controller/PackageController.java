package com.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.InternetPackage;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin(origins = "http://localhost:3000")
public class PackageController {

    @GetMapping
    public List<InternetPackage> getPackages() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return List.of(
                mapper.readValue(
                        new File("src/main/resources/packages.json"),
                        InternetPackage[].class
                )
        );
    }
}
