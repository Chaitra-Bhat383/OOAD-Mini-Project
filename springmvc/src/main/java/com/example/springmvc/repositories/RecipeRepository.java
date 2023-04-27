package com.example.springmvc.repositories;

import com.example.springmvc.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long>{
    Recipe findByRecipeName(final String recipeName);
}

