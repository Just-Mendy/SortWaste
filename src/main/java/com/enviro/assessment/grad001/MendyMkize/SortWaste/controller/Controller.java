package com.enviro.assessment.grad001.MendyMkize.SortWaste.controller;

import com.enviro.assessment.grad001.MendyMkize.SortWaste.model.Category;
import com.enviro.assessment.grad001.MendyMkize.SortWaste.services.ServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class Controller {

    private final ServiceImplementation serviceImplementation;

    public Controller(ServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){
        Category save = serviceImplementation.createCategory(category);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        Category category = serviceImplementation.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> AllCategories = serviceImplementation.getAllCategory();
        return ResponseEntity.ok(AllCategories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> upDateCategory(@PathVariable Long id, @RequestBody Category category){
        Category updatedCat = serviceImplementation.updateCategory(id, category);
        return ResponseEntity.ok(updatedCat);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        serviceImplementation.deleteCategoryById(id);
    }

}
