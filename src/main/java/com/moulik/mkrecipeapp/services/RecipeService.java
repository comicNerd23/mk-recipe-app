package com.moulik.mkrecipeapp.services;

import com.moulik.mkrecipeapp.domain.Recipe;


public interface RecipeService {

    Iterable<Recipe> getRecipes();

    Recipe findById(Long id);

}
