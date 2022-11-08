package com.betterworldbook.fakebook.services;

import com.betterworldbook.fakebook.model.Category;
import com.betterworldbook.fakebook.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category addCategories(Category category){
        return categoryRepository.save(category);
    }


    public ResponseEntity<Iterable<Category>> getAllCategories(){
        return  new ResponseEntity<>( categoryRepository.findAll(), HttpStatus.OK);
    }


    ///I want to get a Category based on their id
    public Optional<Category> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }


    public void deleteCategoryByID(Long id) {
        categoryRepository.deleteById(id);
    }


    public void updateCategory(Long id, Category category){
        categoryRepository.save(category);
    }


}

