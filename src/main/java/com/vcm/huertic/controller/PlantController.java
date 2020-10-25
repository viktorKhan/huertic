package com.vcm.huertic.controller;

import com.vcm.huertic.entity.Plant;
import com.vcm.huertic.repository.PlantRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/plant", produces = "application/json")
@CrossOrigin(origins = "*")
public class PlantController {

    private final PlantRepository plantRepository;

    public PlantController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @GetMapping("/recent")
    public Iterable<Plant> getAll() {
        PageRequest page = PageRequest.of(0, 10, Sort.by("species").descending());
        return plantRepository.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getById(@PathVariable("id") String id) {
        Optional<Plant> plant = plantRepository.findById(id);
        return plant
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Plant addPlant(@RequestBody Plant plant) {
        return plantRepository.save(plant);
    }
}
