package com.cuellar.productcatalogproduct.service.category;

import com.cuellar.productcatalogproduct.commons.dto.CategoryDto;
import com.cuellar.productcatalogproduct.commons.response.CategoryResponseDto;
import com.cuellar.productcatalogproduct.models.entity.Category;
import com.cuellar.productcatalogproduct.repository.category.impl.ICategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {


    @Autowired
    private ICategoryFacade iCategoryFacade;

    @Override
    public ResponseEntity<?> listCategoryParent(int page, int size) {
        Page<Category> categoryList = iCategoryFacade.findAllParent(PageRequest.of(page, size));
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDtoList.add(changeType(category));
        }
        CategoryResponseDto responseDto = changeResponse(categoryDtoList,categoryList);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> listCategoryChildren(Long idParent,int page, int size) {
        Page<Category> categoryList = iCategoryFacade.findCategoryByChildren(idParent,PageRequest.of(page, size));
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDtoList.add(changeType(category));
        }
        CategoryResponseDto responseDto = changeResponse(categoryDtoList,categoryList);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public CategoryDto changeType(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setIdCategoryParent(category.getIdCategory());
        categoryDto.setNameCategoryParent(category.getName());
        categoryDto.setPhotoCategoryParent(category.getPhoto());
        categoryDto.setLastLevel(!(category.getChildren().size() > 0));
        return categoryDto;
    }

    public CategoryResponseDto changeResponse(List<CategoryDto> categoryDtoList, Page<Category> categoryList) {
        CategoryResponseDto responseDto = new CategoryResponseDto();
        responseDto.setCategoryDtoList(categoryDtoList);
        responseDto.setTotalItems(categoryList.getTotalElements());
        responseDto.setTotalPages(categoryList.getTotalPages());
        return responseDto;
    }

}
