package com.example.recipe.recipe_backend.repository;

import com.example.recipe.recipe_backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}