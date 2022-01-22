package com.moulik.mkrecipeapp.repositories;

import com.moulik.mkrecipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
