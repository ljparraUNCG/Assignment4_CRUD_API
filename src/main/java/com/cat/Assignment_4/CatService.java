package com.cat.Assignment_4;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public Optional<Cat> getCatById(int id) {
        return catRepository.findById(id);
    }

    public Cat addCat(Cat cat) {
        return catRepository.save(cat);
    }

    public Cat updateCat(int catId, Cat cat) {
        // Retrieve the cat from the database using the catId
        Cat existingCat = catRepository.findById(catId)
                .orElseThrow(() -> new RuntimeException("Cat not found"));

        // Update the fields with the values from the request
        existingCat.setName(cat.getName());
        existingCat.setDescription(cat.getDescription());
        existingCat.setBreed(cat.getBreed());
        existingCat.setDiet(cat.getDiet());
        existingCat.setHome(cat.getHome());

        // Save the updated cat and return it
        return catRepository.save(existingCat);
    }

    public void deleteCat(int id) {
        catRepository.deleteById(id);
    }

    public List<Cat> getCatsByBreed(String breed) {
        return catRepository.findByBreed(breed);
    }

    public List<Cat> getCatsByDiet(String diet) {
        return catRepository.findByDiet(diet);
    }

    public List<Cat> getCatsByHome(String home) {
        return catRepository.findByHome(home);
    }

    public List<Cat> getCatsByName(String name) {
        return catRepository.findByNameContaining(name);
    }


}