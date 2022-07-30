package com.moulik.mkrecipeapp.services;

import com.moulik.mkrecipeapp.domain.Recipe;
import com.moulik.mkrecipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {

        Recipe recipe = new Recipe();
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipeSet);

        Iterable<Recipe> recipes = recipeService.getRecipes();
        assertEquals(1, recipes.spliterator().getExactSizeIfKnown());
        verify(recipeRepository, times(1)).findAll();

    }

    @Test
    void getRecipeByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));

        Recipe rec = recipeService.findById(1L);
        assertNotNull(rec);
        assertEquals(1L, rec.getId());
    }
}