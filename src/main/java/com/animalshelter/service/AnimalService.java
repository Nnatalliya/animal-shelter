package com.animalshelter.service;

import com.animalshelter.DTO.AnimalDTO;
import com.animalshelter.model.Animal;
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

    public List<Animal> findAll() {
       List<AnimalDTO> result = new ArrayList<>();
        List<Animal> animals=repository.findAll();
        for(int i=0;i<animals.size();i++) {
            result.add(AnimalDTO.builder()
                    .age(animals.get(i).getAge())
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
