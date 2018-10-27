package com.bahaida.recipeapp.controllers;

import com.bahaida.recipeapp.domain.Category;
import com.bahaida.recipeapp.domain.UnitOfMeasure;
import com.bahaida.recipeapp.repositories.CategoryRepository;
import com.bahaida.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller

public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","index"})
    public String renderIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("Italian");
        Optional<UnitOfMeasure> measureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("Cat ID: "+categoryOptional.get().getId());
        System.out.println("UOM ID: "+measureOptional.get().getId());
        return "index";
    }
}
