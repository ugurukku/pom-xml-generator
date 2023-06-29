package com.ugurukku.generator.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public record PomRequest (
        @NotBlank
        String springVersion,

        @NotBlank
        String group,

        @NotBlank
        String artifact,

        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        Integer javaVersion,

        Set<Integer> dependencies
){
}
