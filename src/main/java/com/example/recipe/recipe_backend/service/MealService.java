package com.example.recipe.recipe_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MealService {

    private final String API_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    public String searchMeal(String mealName) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(API_URL + mealName, String.class);
    }
}