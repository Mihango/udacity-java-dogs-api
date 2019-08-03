package com.example.dogs.service;

import com.example.dogs.models.Dog;
import com.example.dogs.repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DogService {

    private DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<String> retrieveDogBreed() {
        return StreamSupport.stream(dogRepository.findAll().spliterator(), false)
                .map(Dog::getBreed)
                .collect(Collectors.toList());
    }

    public Optional<Dog> retrieveDogById(Long id) {
        return dogRepository.findById(id);
    }

    public List<String> retrieveDogNames() {
        return StreamSupport.stream(dogRepository.findAll().spliterator(), false)
                .map(Dog::getName)
                .collect(Collectors.toList());
    }
}
