package com.moulik.mkrecipeapp.converters;

import com.moulik.mkrecipeapp.commands.UnitOfMeasureCommand;
import com.moulik.mkrecipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureToUnitOfMeasureCommandTest {

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    void testNull() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmpty() {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    void convert() {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);
        unitOfMeasure.setDescription("Teaspoon");
        UnitOfMeasureCommand command = converter.convert(unitOfMeasure);
        assertEquals(1L, command.getId());
        assertEquals("Teaspoon", command.getDescription());
    }
}