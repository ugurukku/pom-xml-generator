package com.ugurukku.generator.controller;

import com.ugurukku.generator.dto.PomRequest;
import com.ugurukku.generator.service.GeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/generator")
@RequiredArgsConstructor
public class PomController {

    private final GeneratorService generatorService;

    @PostMapping("/pom")
    public ResponseEntity<Object> generatePom(@RequestBody @Valid PomRequest pomRequest) {
        generatorService.generatePom(pomRequest);

        return ResponseEntity.created(URI.create("/api/files/pom.xml")).build();
    }

}
