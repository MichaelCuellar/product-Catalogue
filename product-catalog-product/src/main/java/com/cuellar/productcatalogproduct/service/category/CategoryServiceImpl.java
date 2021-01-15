package com.cuellar.productcatalogproduct.service.category;

import com.cuellar.productcatalogproduct.commons.dto.CategoryParentDto;
import com.cuellar.productcatalogproduct.models.entity.Category;
import com.cuellar.productcatalogproduct.repository.category.impl.ICategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryFacade iCategoryFacade;

    @Override
    public List<CategoryParentDto> listCategoryParent() {
        List<Category> categoryList = iCategoryFacade.findAllParent();
        List<CategoryParentDto> categoryParentDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryParentDtoList.add(changeType(category));
        }
        return categoryParentDtoList;
    }

    @Override
    public List<CategoryParentDto> listCategoryChildren(Long idParent) {
        List<Category> categoryList = iCategoryFacade.findCategoryByChildren(idParent);
        List<CategoryParentDto> categoryParentDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryParentDtoList.add(changeType(category));
        }
        return categoryParentDtoList;
    }

    public CategoryParentDto changeType(Category category){
        CategoryParentDto categoryParentDto = new CategoryParentDto();
        categoryParentDto.setIdCategoryParent(category.getIdCategory());
        categoryParentDto.setNameCategoryParent(category.getName());
        categoryParentDto.setPhotoCategoryParent(category.getPhoto());
        categoryParentDto.setLastLevel(!(category.getChildren().size() > 0));
        return categoryParentDto;
    }
}
