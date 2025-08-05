package com.animalshelter.service;

import com.animalshelter.DTO.AnimalDTO;
import com.animalshelter.entity.Animal;
import com.animalshelter.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public List<AnimalDTO> findAll() {
        List<AnimalDTO> result = new ArrayList<>();
        List<Animal> animals = repository.findAll();

        for (Animal animal : animals) {
            result.add(AnimalDTO.builder()
                    .age(animal.getAge())
                    .build());
        }

        return result;
    }

    public Optional<Animal> findById(Long id) {
        return repository.findById(id);
    }

    public Animal save(Animal animal) {
        return repository.save(animal);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
