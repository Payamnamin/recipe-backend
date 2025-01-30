package com.example.recipe.recipe_backend.controller;

import com.example.recipe.recipe_backend.model.Recipe;
import com.example.recipe.recipe_backend.repository.RecipeRepository;
import com.example.recipe.recipe_backend.service.MealService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity<JsonNode> searchMeal(@PathVariable String mealName) {
    try {
        String response = mealService.searchMeal(mealName);

        if (response == null || response.trim().isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }

        /*  Convert a JSON string in to an actual JSON structre
        without additional escapes*/
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.trim());

        return ResponseEntity.ok(jsonNode);
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body(null);
    }
}
    // add a favorite recipe to the database
    @PostMapping("/save")
public ResponseEntity<?> saveFavoriteRecipe(@RequestBody Recipe recipe) {
    try {
        if (recipe == null || recipe.getRecipeName() == null || recipe.getRecipeName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("{\"error\": \"Recipe data is invalid or missing!\"}");
        }

        Recipe savedRecipe = recipeRepository.save(recipe);

        // تبدیل `savedRecipe` به JSON معتبر
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRecipe = objectMapper.writeValueAsString(savedRecipe);

        return ResponseEntity.ok("{\"message\": \"Recipe saved successfully\", \"recipe\": " + jsonRecipe + "}");
        
    } catch (Exception e) {
        return ResponseEntity.status(500).body("{\"error\": \"Error saving recipe: " + e.getMessage() + "\"}");
    }
    

}



   

    

    
}
