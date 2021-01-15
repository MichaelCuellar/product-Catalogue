package com.cuellar.productcatalogproduct.repository.category.impl;

import com.cuellar.productcatalogproduct.models.entity.Category;
import com.cuellar.productcatalogproduct.repository.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CategoryImpl implements ICategoryFacade{

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public boolean addCategory(Category category) {
        return !ObjectUtils.isEmpty(iCategoryRepository.save(category));
    }

    @Override
    public Category findCategoryById(Long idCategory) {
        return iCategoryRepository.findById(idCategory).orElse(null);
    }

    @Override
    public List<Category> findAllParent() {
        return iCategoryRepository.findCategoryParent();
    }

    @Override
    public List<Category> findCategoryByChildren(Long idParent) {
        return iCategoryRepository.findCategoryByChildren(idParent);
    }
}
