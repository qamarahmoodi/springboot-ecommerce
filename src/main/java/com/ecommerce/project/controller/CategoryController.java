package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryServiceImpl categoryService;
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/public/categories")
    public ResponseEntity<?> createCategory(@Valid @RequestBody Category category) {
        String status = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        String status = categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(status);
    }

    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
        Category updatedCategory = categoryService.updateCategory(categoryId, category);
        return ResponseEntity.ok(updatedCategory);
    }

}
