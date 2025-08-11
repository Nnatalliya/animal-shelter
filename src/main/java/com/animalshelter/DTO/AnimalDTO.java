package com.animalshelter.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AnimalDTO {
    private String name;
    private String species;
    private Integer age;
}
