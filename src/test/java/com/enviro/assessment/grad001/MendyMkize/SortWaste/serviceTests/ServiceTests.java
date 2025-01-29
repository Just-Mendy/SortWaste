package com.enviro.assessment.grad001.MendyMkize.SortWaste.serviceTests;


import com.enviro.assessment.grad001.MendyMkize.SortWaste.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.MendyMkize.SortWaste.model.Category;
import com.enviro.assessment.grad001.MendyMkize.SortWaste.repository.CategoryRepository;
import com.enviro.assessment.grad001.MendyMkize.SortWaste.services.ServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceImplementationTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ServiceImplementation serviceImplementation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCategory() {
        // Arrange
        Category category = new Category();
        category.setId(1L);
        category.setName("Recyclable");
        when(categoryRepository.save(category)).thenReturn(category);

        // Act
        Category result = serviceImplementation.createCategory(category);

        // Assert
        assertNotNull(result);
        assertEquals("Recyclable", result.getName());
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testGetCategoryById_Success() {
        // Arrange
        Long id = 1L;
        Category category = new Category();
        category.setId(id);
        category.setName("Organic");
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));

        // Act
        Category result = serviceImplementation.getCategoryById(id);

        // Assert
        assertNotNull(result);
        assertEquals("Organic", result.getName());
        verify(categoryRepository, times(1)).findById(id);
    }

    @Test
    void testGetCategoryById_NotFound() {
        // Arrange
        Long id = 1L;
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> serviceImplementation.getCategoryById(id));
        verify(categoryRepository, times(1)).findById(id);
    }
}
