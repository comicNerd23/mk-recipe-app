package com.moulik.mkrecipeapp.services;

import com.moulik.mkrecipeapp.domain.Recipe;

import java.util.Optional;

public interface RecipeService {

    Iterable<Recipe> getRecipes();

}
