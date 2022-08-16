package com.moulik.mkrecipeapp.converters;

import com.moulik.mkrecipeapp.commands.IngredientCommand;
import com.moulik.mkrecipeapp.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand converter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand converter) {
        this.converter = converter;
    }

    @Nullable
    @Synchronized
    @Override
    public IngredientCommand convert(Ingredient source) {
        if(source == null) {
            return null;
        }
        IngredientCommand command = new IngredientCommand();
        command.setId(source.getId());
        command.setAmount(source.getAmount());
        command.setDescription(source.getDescription());
        command.setUnitOfMeasureCommand(converter.convert(source.getUnitOfMeasure()));
        return command;
    }
}
