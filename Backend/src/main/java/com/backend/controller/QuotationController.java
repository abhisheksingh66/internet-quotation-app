package com.backend.controller;

import com.backend.model.Quotation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/quotations")
@CrossOrigin(origins = "http://localhost:3000")
public class QuotationController {
    ObjectMapper mapper = new ObjectMapper();
    String filePath = "src/main/resources/quotations.json";

    @PostMapping
    public Map<String, Long> submit(@RequestBody Quotation quotation) throws Exception {
 List<Quotation> list = new ArrayList<>(
                List.of(mapper.readValue(new File(filePath), Quotation[].class))
        );

        quotation.id = System.currentTimeMillis();
        quotation.status = "PENDING";
        quotation.comment = "";
        
        list.add(quotation);
        mapper.writeValue(new File(filePath), list);
         return Map.of("quotationId", quotation.id);
    }

    @GetMapping
    public List<Quotation> getAll() throws Exception {
        return List.of(
      mapper.readValue(new File(filePath), Quotation[].class)
        );
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Quotation data) throws Exception {
        List<Quotation> list = new ArrayList<>(
                List.of(mapper.readValue(new File(filePath), Quotation[].class))
        );

        for (Quotation q : list) {
            if (q.id == id) {
                q.status = data.status;
                q.comment = data.comment;
            }
} 
        mapper.writeValue(new File(filePath), list);
    }
     
}
