package com.animalshelter.DTO;

import lombok.Builder;

@Builder
public class AnimalDTO {
    private String name;
    private String species;
    private Integer age;
}
