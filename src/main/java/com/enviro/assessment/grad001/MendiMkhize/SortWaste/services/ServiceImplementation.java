package com.enviro.assessment.grad001.MendiMkhize.SortWaste.services;

import com.enviro.assessment.grad001.MendiMkhize.SortWaste.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.MendiMkhize.SortWaste.model.Category;
import com.enviro.assessment.grad001.MendiMkhize.SortWaste.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImplementation implements IService{

    private final CategoryRepository categoryRepository;

    public ServiceImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        Category categoryToUpdate = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found"));
        categoryToUpdate.setId(updatedCategory.getId());
        categoryToUpdate.setName(updatedCategory.getName());
        categoryToUpdate.setDisposalGuidelines(updatedCategory.getDisposalGuidelines());
        categoryToUpdate.setRecyclingTips(updatedCategory.getRecyclingTips());
        return categoryRepository.save(categoryToUpdate);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);

    }
}
