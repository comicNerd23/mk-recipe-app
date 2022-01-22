package com.moulik.mkrecipeapp.repositories;

import com.moulik.mkrecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
