package com.moulik.mkrecipeapp.services;

import com.moulik.mkrecipeapp.commands.NotesCommand;
import com.moulik.mkrecipeapp.commands.RecipeCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecipeServiceIT {

    @Autowired
    RecipeService recipeService;

    @Test
    void saveRecipeCommandTest() {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);
        recipeCommand.setDescription("Some Recipe");
        recipeCommand.setNotes(new NotesCommand());
        RecipeCommand command = recipeService.saveRecipeCommand(recipeCommand);
        assertEquals(1L, command.getId());
        assertEquals("Some Recipe", command.getDescription());
    }
}
