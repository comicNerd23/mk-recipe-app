package com.moulik.mkrecipeapp.services;

import com.moulik.mkrecipeapp.commands.RecipeCommand;
import com.moulik.mkrecipeapp.domain.Recipe;


public interface RecipeService {

    Iterable<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteRecipeById(Long id);

}
