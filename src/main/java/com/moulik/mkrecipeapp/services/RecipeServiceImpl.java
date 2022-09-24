package com.moulik.mkrecipeapp.services;

import com.moulik.mkrecipeapp.commands.RecipeCommand;
import com.moulik.mkrecipeapp.converters.RecipeCommandToRecipe;
import com.moulik.mkrecipeapp.converters.RecipeToRecipeCommand;
import com.moulik.mkrecipeapp.domain.Recipe;
import com.moulik.mkrecipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Iterable<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Long id) {
        return recipeRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Recipe Not Found"));
    }

    @Override
    public RecipeCommand findCommandById(Long id) {
        return recipeToRecipeCommand.convert(this.findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(recipeCommand);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }
}
