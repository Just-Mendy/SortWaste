package com.enviro.assessment.grad001.MendyMkize.SortWaste.services;

import com.enviro.assessment.grad001.MendyMkize.SortWaste.model.Category;

import java.util.List;

public interface IService {

    Category createCategory(Category category);
    Category getCategoryById(Long id);
    List<Category> getAllCategory();
    Category updateCategory(Long id, Category updatedCategory);
    void deleteCategoryById(Long id);

}
