package com.example.dogs.service;

import com.example.dogs.repository.DogRepository;

public class DogService {

    private DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }
}
