package com.betterworldbook.fakebook.controller;

import com.betterworldbook.fakebook.model.Category;
import com.betterworldbook.fakebook.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{categoryId}")
    public Optional<Category> getCategoryById(@PathVariable Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategories(category);
    }

    @PutMapping("/category/{categoryId}")
    public void updateCategory(@PathVariable Long categoryId, @RequestBody Category category){
        categoryService.updateCategory(categoryId,category);
    }

    @DeleteMapping("/category/{categoryId}")
    public void deleteCategoryById(@PathVariable Long categoryId) {
        categoryService.deleteCategoryByID(categoryId);

    }




}
