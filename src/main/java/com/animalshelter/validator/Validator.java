package com.animalshelter.validator;

import com.animalshelter.entity.Animal;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    public void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID трябва да е положително число!");
        }
    }

    public void validateAge(Integer age) {
        if (age == null) {
            throw new IllegalArgumentException("Възрастта трябва да бъде зададена!");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Възрастта не може да е отрицателна!");
        }
        if (age > 30) { // или >50 според заданието
            throw new IllegalArgumentException("Възрастта не може да бъде над 30 години!");
        }
    }

    public void validateForCreate(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Невалиден обект животно.");
        }
        if (animal.getName() == null || animal.getName().isBlank()) {
            throw new IllegalArgumentException("Името е задължително.");
        }
        if (animal.getType() == null || animal.getType().isBlank()) {
            throw new IllegalArgumentException("Типът е задължителен.");
        }
        validateAge(animal.getAge());
    }
}
