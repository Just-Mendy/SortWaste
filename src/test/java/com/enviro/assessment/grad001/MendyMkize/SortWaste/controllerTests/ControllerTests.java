package com.enviro.assessment.grad001.MendyMkize.SortWaste.controllerTests;


import com.enviro.assessment.grad001.MendyMkize.SortWaste.controller.Controller;
import com.enviro.assessment.grad001.MendyMkize.SortWaste.model.Category;
import com.enviro.assessment.grad001.MendyMkize.SortWaste.services.ServiceImplementation;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Controller.class)
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ServiceImplementation serviceImplementation;

    @Test
    void testCreateCategory() throws Exception {
        // Arrange
        Category category = new Category();
        category.setId(1L);
        category.setName("Recyclable");
        when(serviceImplementation.createCategory(any(Category.class))).thenReturn(category);

        // Act & Assert
        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Recyclable\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Recyclable"));

        verify(serviceImplementation, times(1)).createCategory(any(Category.class));
    }

    @Test
    void testGetCategoryById_Success() throws Exception {
        // Arrange
        Long id = 1L;
        Category category = new Category();
        category.setId(id);
        category.setName("Organic");
        when(serviceImplementation.getCategoryById(id)).thenReturn(category);

        // Act & Assert
        mockMvc.perform(get("/api/categories/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Organic"));

        verify(serviceImplementation, times(1)).getCategoryById(id);
    }

    @Test
    void testGetCategoryById_NotFound() throws Exception {
        // Arrange
        Long id = 1L;
        when(serviceImplementation.getCategoryById(id)).thenThrow(new RuntimeException("Category not found"));

        // Act & Assert
        mockMvc.perform(get("/api/categories/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(serviceImplementation, times(1)).getCategoryById(id);
    }
}