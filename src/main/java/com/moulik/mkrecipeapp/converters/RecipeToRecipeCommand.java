package com.moulik.mkrecipeapp.converters;

import com.moulik.mkrecipeapp.commands.CategoryCommand;
import com.moulik.mkrecipeapp.commands.IngredientCommand;
import com.moulik.mkrecipeapp.commands.RecipeCommand;
import com.moulik.mkrecipeapp.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    NotesToNotesCommand notesConverter;
    CategoryToCategoryCommand categoryConverter;
    IngredientToIngredientCommand ingredientConverter;

    public RecipeToRecipeCommand(NotesToNotesCommand notesConverter, CategoryToCategoryCommand categoryConverter, IngredientToIngredientCommand ingredientConverter) {
        this.notesConverter = notesConverter;
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
    }

    @Nullable
    @Synchronized
    @Override
    public RecipeCommand convert(Recipe source) {
        RecipeCommand command = new RecipeCommand();
        command.setId(source.getId());
        command.setDescription(source.getDescription());
        command.setUrl(source.getUrl());
        command.setServings(source.getServings());
        command.setCookTime(source.getCookTime());
        command.setPrepTime(source.getPrepTime());
        command.setDifficulty(source.getDifficulty());
        command.setDirections(source.getDirections());
        command.setImage(source.getImage());
        command.setNotes(notesConverter.convert(source.getNotes()));
        Set<CategoryCommand> categorySet = new HashSet<>();
        source.getCategories().forEach(c -> categorySet.add(categoryConverter.convert(c)));
        command.setCategories(categorySet);
        Set<IngredientCommand> ingredientSet = new HashSet<>();
        source.getIngredients().forEach(i -> ingredientSet.add(ingredientConverter.convert(i)));
        command.setIngredients(ingredientSet);
        return command;
    }
}
