package com.animalshelter.DTO;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class AnimalDTO implements Serializable {
    private String name;
    private String species;
    private Integer age;
}
