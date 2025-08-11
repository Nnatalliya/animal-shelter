package com.animalshelter.controller;
import com.animalshelter.DTO.AnimalDTO;


import com.animalshelter.entity.Animal;
import com.animalshelter.service.AnimalService;
import lombok.Builder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@CrossOrigin(origins = "*")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public List<AnimalDTO> getAll() {
        return service.findAll(); // <- Тук връщаме DTO
    }


    @GetMapping("/api/animals/{id}")
    public ResponseEntity<Animal> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        return service.save(animal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
