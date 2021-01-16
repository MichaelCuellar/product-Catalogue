package com.cuellar.productcatalogproduct.repository.category.impl;

import com.cuellar.productcatalogproduct.models.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryFacade {

    boolean addCategory(Category category);
    Category findCategoryById(Long idCategory);
    Page<Category> findAllParent(Pageable pageable);
    Page<Category> findCategoryByChildren(Long idParent,Pageable pageable);
}
