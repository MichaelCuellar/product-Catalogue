package com.cuellar.productcatalogproduct.repository.category.impl;

import com.cuellar.productcatalogproduct.models.entity.Category;

import java.util.List;

public interface ICategoryFacade {

    boolean addCategory(Category category);
    Category findCategoryById(Long idCategory);
    List<Category> findAllParent();
    List<Category> findCategoryByChildren(Long idParent);
}
