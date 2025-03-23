package com.cat.Assignment_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @GetMapping("/{id}")
    public Optional<Cat> getCatById(@PathVariable int id) {
        return catService.getCatById(id);
    }

    @PostMapping
    public ResponseEntity<Cat> addCat(@RequestBody Cat cat) {
        Cat savedCat = catService.addCat(cat);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCat);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<Cat> updateCat(@PathVariable int catId, @RequestBody Cat cat) {
        try {

            Cat updatedCat = catService.updateCat(catId, cat);


            return ResponseEntity.ok(updatedCat);
        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable int id) {
        catService.deleteCat(id);
    }

    @GetMapping("/breed/{breed}")
    public List<Cat> getCatsByBreed(@PathVariable String breed) {
        return catService.getCatsByBreed(breed);
    }

    @GetMapping("/diet/{diet}")
    public List<Cat> getCatsByDiet(@PathVariable String diet) {
        return catService.getCatsByDiet(diet);
    }

    @GetMapping("/home/{home}")
    public List<Cat> getCatsByHome(@PathVariable String home) {
        return catService.getCatsByHome(home);
    }

    @GetMapping("/search/{name}")
    public List<Cat> getCatsByName(@PathVariable String name) {
        return catService.getCatsByName(name);
    }
}