package com.projetb32.GSA.controller;


import com.projetb32.GSA.entity.Category;
import com.projetb32.GSA.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/categorys")
    public ResponseEntity<List<Category>> retreivePictures() {

        List<Category> categoryList = null;
        categoryList = categoryService.getAllCategory();
        if (categoryList.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);

    }

    @GetMapping("/categorys/{categoryId}")
    public ResponseEntity<Optional<Category>> retreiveCategoryById(@PathVariable long categoryId) {
        Optional<Category> categoryList;
        categoryList = categoryService.getCategoryById(categoryId);

        if (!categoryList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);

    }
/*
    @PostMapping("/categorys/{categoryId}")
    public ResponseEntity<Category> addPicture(@RequestBody Category category, @PathVariable long categoryId) {
        Category categoryObject = categoryService.getCategoryById(categoryId).get();
        category.setParentCategory(categoryObject);
        Category categoryLocal = categoryService.addCategory(category);

        if (categoryLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(categoryLocal, HttpStatus.OK);

    }
*/
    @PutMapping("/categorys/{categoryId}/{parentCategoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable long categoryId, @RequestBody Category category,@PathVariable long parentCategoryId) {
        Category pictureLocal = categoryService.updateCategory(categoryId, category,parentCategoryId);
        if (pictureLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(pictureLocal, HttpStatus.OK);
    }

    @DeleteMapping("/categorys/{categoryId}")
    public ResponseEntity<Category> deletePicture(@PathVariable long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.accepted().build();
    }
/*
    @GetMapping("/categorys/recipes/{idCategory}")
    public ResponseEntity<List<Recipe>> findRecipesByCategory(@PathVariable long idCategory) {
        return new ResponseEntity<>(categoryService.findRecipesByCategory(idCategory), HttpStatus.OK);
    }

*/
}
