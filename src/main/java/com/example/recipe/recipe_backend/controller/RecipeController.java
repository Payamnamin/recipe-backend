package com.example.recipe.recipe_backend.controller;

import com.example.recipe.recipe_backend.model.Recipe;
import com.example.recipe.recipe_backend.repository.RecipeRepository;
import com.example.recipe.recipe_backend.service.MealService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    // Add a food recipe (POST)
    @PostMapping
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    // Show all food recipes (GET)
    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    // Delete a food recipe byID (DELETE)
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
    }

    @Autowired
    private MealService mealService;

    // Search for a meal by name using the Meal Database API
    @GetMapping("/search/{mealName}")
    public String searchMeal(@PathVariable String mealName) {
        return mealService.searchMeal(mealName);
    }
    // add a favorite recipe to the database
    @PostMapping("/save")
     public Recipe saveFavoriteRecipe(@RequestBody Recipe recipe) {
    return recipeRepository.save(recipe);
}



   

    

    
}
