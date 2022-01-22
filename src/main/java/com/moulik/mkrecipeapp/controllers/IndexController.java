package com.moulik.mkrecipeapp.controllers;

import com.moulik.mkrecipeapp.domain.Category;
import com.moulik.mkrecipeapp.domain.UnitOfMeasure;
import com.moulik.mkrecipeapp.repositories.CategoryRepository;
import com.moulik.mkrecipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage() {

        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Ounce");

        category.ifPresent(value -> System.out.println("Category id:" + value.getId() +
                " category description: " + value.getDescription()));
        uom.ifPresent(unitOfMeasure -> System.out.println("Unit Of Measure id:" + unitOfMeasure.getId() +
                " Unit Of Measure description: " + unitOfMeasure.getDescription()));

        return "index";
    }
}
