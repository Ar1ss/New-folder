package com.zookeper.zookeper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooAnimalController {

    @Autowired
    private ZooAnimalRepository zooAnimalRepository;
    
    @GetMapping("/zooanimals")
    public List<ZooAnimal> getZooAnimals(){
        return zooAnimalRepository.findAll();
    }
    
    @PostMapping("/zooanimals")
    public ZooAnimal createZooAnimal(@RequestBody ZooAnimal zooAnimal) {
        zooAnimalRepository.save(zooAnimal);
        return zooAnimal;

    }
}

interface ZooAnimalRepository extends JpaRepository<ZooAnimal, Integer> {}