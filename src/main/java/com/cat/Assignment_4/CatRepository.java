package com.cat.Assignment_4;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
    List<Cat> findByBreed(String breed);
    List<Cat> findByDiet(String diet);
    List<Cat> findByHome(String home);
    List<Cat> findByNameContaining(String name);
}