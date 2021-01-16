package com.cuellar.productcatalogproduct.repository.category.impl;

import com.cuellar.productcatalogproduct.models.entity.Category;
import com.cuellar.productcatalogproduct.repository.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Category> findAllParent(Pageable pageable) {
        return iCategoryRepository.findCategoryParent(pageable);
    }

    @Override
    public Page<Category> findCategoryByChildren(Long idParent,Pageable pageable) {
        return iCategoryRepository.findCategoryByChildren(idParent,pageable);
    }
}
