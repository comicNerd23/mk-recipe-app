package com.moulik.mkrecipeapp.converters;

import com.moulik.mkrecipeapp.commands.RecipeCommand;
import com.moulik.mkrecipeapp.domain.Category;
import com.moulik.mkrecipeapp.domain.Ingredient;
import com.moulik.mkrecipeapp.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    NotesCommandToNotes notesConverter;
    IngredientCommandToIngredient ingredientConverter;
    CategoryCommandToCategory categoryConverter;

    public RecipeCommandToRecipe(NotesCommandToNotes notesConverter, IngredientCommandToIngredient ingredientConverter, CategoryCommandToCategory categoryConverter) {
        this.notesConverter = notesConverter;
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
    }

    @Nullable
    @Synchronized
    @Override
    public Recipe convert(RecipeCommand source) {
        Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setDescription(source.getDescription());
        recipe.setUrl(source.getUrl());
        recipe.setServings(source.getServings());
        recipe.setCookTime(source.getCookTime());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDirections(source.getDirections());
        recipe.setNotes(notesConverter.convert(source.getNotes()));
        Set<Category> categorySet = new HashSet<>();
        source.getCategories().forEach(c -> categorySet.add(categoryConverter.convert(c)));
        recipe.setCategories(categorySet);
        Set<Ingredient> ingredientSet = new HashSet<>();
        source.getIngredients().forEach(i -> ingredientSet.add(ingredientConverter.convert(i)));
        recipe.setIngredients(ingredientSet);
        return recipe;
    }
}
