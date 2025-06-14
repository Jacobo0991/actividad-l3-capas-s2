package com.labo03.labo03.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateClub {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String country;

    @NotNull
    @NotBlank
    private String coach;

    @NotNull
    private int titles;
}
