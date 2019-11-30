package com.projetb32.GSA.service;

import com.projetb32.GSA.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projetb32.GSA.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> getCategoryBytype(String type) {
        return categoryRepository.findByType(type);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category updateCategory(Long id, Category category,long parentCategoryId) {

        Category categoryFound = categoryRepository.findById(id).get();
        Category categoryParent = categoryRepository.findById(parentCategoryId).get();

        categoryRepository.save(categoryFound);
        return categoryFound;
    }




}
