package com.backend.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import model.Quotation;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/api/quotations")
@CrossOrigin(origins = "http://localhost:3000")
public class QuotationController {

    private final ObjectMapper mapper = new ObjectMapper();
    private final String FILE = "src/main/resources/quotations.json";

    @PostMapping
    public Map<String, Long> submit(@RequestBody Quotation q) throws Exception {
        List<Quotation> list = new ArrayList<>(
                List.of(mapper.readValue(new File(FILE), Quotation[].class))
        );
        q.id = System.currentTimeMillis();
        q.status = "PENDING";
        q.comment = "";
        list.add(q);
        mapper.writeValue(new File(FILE), list);
        return Map.of("quotationId", q.id);
    }

    @GetMapping
    public List<Quotation> getAll() throws Exception {
        return List.of(mapper.readValue(new File(FILE), Quotation[].class));
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Quotation req) throws Exception {
        List<Quotation> list = new ArrayList<>(
                List.of(mapper.readValue(new File(FILE), Quotation[].class))
        );
        for (Quotation q : list) {
            if (q.id == id) {
                q.status = req.status;
                q.comment = req.comment;
            }
        }
        mapper.writeValue(new File(FILE), list);
    }
}
