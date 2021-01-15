package com.cuellar.productcatalogproduct.service.category;


import com.cuellar.productcatalogproduct.commons.dto.CategoryParentDto;
import com.cuellar.productcatalogproduct.models.entity.Category;


import java.util.List;

public interface ICategoryService {

    List<CategoryParentDto> listCategoryParent();

    List<CategoryParentDto> listCategoryChildren(Long idParent);
}
