package com.moulik.mkrecipeapp.converters;

import com.moulik.mkrecipeapp.commands.IngredientCommand;
import com.moulik.mkrecipeapp.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure converter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure converter) {
        this.converter = converter;
    }

    @Nullable
    @Synchronized
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source == null) {
            return null;
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setDescription(source.getDescription());
        ingredient.setAmount(source.getAmount());
        ingredient.setUnitOfMeasure(converter.convert(source.getUnitOfMeasureCommand()));
        return ingredient;
    }
}
