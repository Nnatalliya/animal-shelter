package com.animalshelter.controller;

import com.animalshelter.DTO.AnimalDTO;
import com.animalshelter.entity.Animal;
import com.animalshelter.service.AnimalService;
import com.animalshelter.validator.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@CrossOrigin(origins = "*")
public class AnimalController {

    private final AnimalService service;
    private final Validator validator;

    public AnimalController(AnimalService service, Validator validator) {
        this.service = service;
        this.validator = validator;
    }

    @GetMapping("/getall")
    public List<AnimalDTO> getAll() {
        return service.findAll();
    }

    // <-- Важна промяна тук: относителен път
    @GetMapping("/{id}")
    public ResponseEntity<Animal> getById(@PathVariable Long id) {
        // 1) Валидирай ID
        validator.validateId(id);

        // 2) Вземи животното от сервиза
        return service.findById(id)
                .map(animal -> {
                    // 3) Валидирай възрастта преди да върнеш
                    validator.validateAge(animal.getAge());
                    return ResponseEntity.ok(animal);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        // ако искаш, можеш да валидираш при създаване:
        validator.validateForCreate(animal);
        return service.save(animal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        validator.validateId(id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

