package com.ugurukku.generator.service.impl;

import com.ugurukku.generator.dto.PomRequest;
import com.ugurukku.generator.repository.Repo;
import com.ugurukku.generator.service.GeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GeneratorServiceImpl implements GeneratorService {

    private final Repo repo;

    @Override
    public void generatePom(PomRequest pomRequest) {

        String pomExample = repo.getPomExample();

        pomExample = pomExample.replace("{springVersion}", pomRequest.springVersion());
        pomExample = pomExample.replace("{groupId}", pomRequest.group());
        pomExample = pomExample.replace("{artifact}", pomRequest.artifact());
        pomExample = pomExample.replace("{name}", pomRequest.name());
        pomExample = pomExample.replace("{description}", pomRequest.description());
        pomExample = pomExample.replace("{javaVersion}", pomRequest.javaVersion().toString());



        StringBuilder creatingDependencies = new StringBuilder();
        Map<Integer, String> existingDependencies = repo.getDependencies();

        for (Integer num : pomRequest.dependencies()) {
            if (existingDependencies.containsKey(num)) {
                creatingDependencies.append(existingDependencies.get(num));
            }
        }

        pomExample = pomExample.replace("{dependencies}", creatingDependencies);

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:/Users/ugurk/Desktop/images/pom.xml");
            fileOutputStream.write(pomExample.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
