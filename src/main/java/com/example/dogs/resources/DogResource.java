package com.example.dogs.resources;

import com.example.dogs.models.Dog;
import com.example.dogs.service.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dogs")
public class DogResource {

    private DogService dogService;

    public DogResource(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/breed")
    public ResponseEntity<?> getDogBreeds() {
        return new ResponseEntity<>( dogService.retrieveDogBreed(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> findDog(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(dogService.retrieveDogById(id), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name")
    public ResponseEntity<?> getDogNames() {
        return new ResponseEntity<>(dogService.retrieveDogNames(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getDogs() {
        return ResponseEntity.ok(dogService.retrieveDogs());
    }
}
