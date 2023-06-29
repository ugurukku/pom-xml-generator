package com.ugurukku.generator.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @GetMapping(value = "/{fileName}",produces = {"application/xml","text/xml"})
    public byte[] getFile(@PathVariable("fileName") String fileName){
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("C:/Users/ugurk/Desktop/images/"+ fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            byte[] file = fileInputStream.readAllBytes();
            fileInputStream.close();
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
