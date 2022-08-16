package com.moulik.mkrecipeapp.converters;

import com.moulik.mkrecipeapp.commands.UnitOfMeasureCommand;
import com.moulik.mkrecipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    void testNull() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    void convert() {
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(1L);
        command.setDescription("Scoop");
        UnitOfMeasure unitOfMeasure = converter.convert(command);
        assertEquals(1L, unitOfMeasure.getId());
        assertEquals("Scoop", unitOfMeasure.getDescription());
    }
}