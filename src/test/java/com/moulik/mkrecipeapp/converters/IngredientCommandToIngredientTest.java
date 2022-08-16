package com.moulik.mkrecipeapp.converters;

import com.moulik.mkrecipeapp.commands.IngredientCommand;
import com.moulik.mkrecipeapp.commands.UnitOfMeasureCommand;
import com.moulik.mkrecipeapp.domain.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {

    IngredientCommandToIngredient converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    void testNull() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmpty() {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    void convert() {
        IngredientCommand command = new IngredientCommand();
        command.setId(1L);
        command.setAmount(BigDecimal.ONE);
        command.setDescription("garlic powder");
        UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
        uomCommand.setId(1L);
        uomCommand.setDescription("teaspoon");
        command.setUnitOfMeasureCommand(uomCommand);
        Ingredient ingredient = converter.convert(command);
        assertEquals(1L, ingredient.getId());
        assertEquals("garlic powder", ingredient.getDescription());
        assertEquals(BigDecimal.ONE, ingredient.getAmount());
        assertEquals(1L, ingredient.getUnitOfMeasure().getId());
        assertEquals("teaspoon", ingredient.getUnitOfMeasure().getDescription());
    }
}