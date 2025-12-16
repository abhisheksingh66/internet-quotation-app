package com.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.backend.model.InternetPackage;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
    
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/packages")
public class PackageController {

    @GetMapping
    public List<InternetPackage> getPackages() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/packages.json");

        InternetPackage[] packages = objectMapper.readValue(
                file,
                InternetPackage[].class
        );

        return List.of(packages);
    }
}
