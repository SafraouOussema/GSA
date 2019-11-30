package com.projetb32.GSA.repository;

import com.projetb32.GSA.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "category", collectionResourceRel = "category")
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByType(String type);

  /* @Query(" select  distinct  r from Recipe r inner join RecipeIngredient ri  " +
            "            on r.id= ri.recipeIngredientPk.recipe.id inner join Ingredient i " +
            "            on ri.recipeIngredientPk.ingredient.id = i.id  inner join Category c " +
            "            on c.id = i.category.id " +
            "            where c.parentCategory.id = (select c2.id from Category c2 " +
            "                                         where c2. id = ?1 )   ")
    List<Recipe> findRecipesByCategory(long idCategory);

*/
}
