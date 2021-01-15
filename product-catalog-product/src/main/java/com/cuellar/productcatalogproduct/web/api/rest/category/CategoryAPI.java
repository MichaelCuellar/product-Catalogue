package com.cuellar.productcatalogproduct.web.api.rest.category;

import com.cuellar.productcatalogproduct.commons.dto.CategoryParentDto;
import com.cuellar.productcatalogproduct.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CategoryAPI {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/parent")
    public List<CategoryParentDto> index() {
        return iCategoryService.listCategoryParent();
    }

    @GetMapping(value = "/children/{id}")
    public List<CategoryParentDto> children(@PathVariable Long id) {
        return iCategoryService.listCategoryChildren(id);
    }
}
