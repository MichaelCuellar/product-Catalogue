package com.cuellar.productcatalogproduct.web.api.rest.category;

import com.cuellar.productcatalogproduct.commons.dto.CategoryDto;
import com.cuellar.productcatalogproduct.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CategoryAPI {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/parent/{size}/{page}")
    public ResponseEntity<?> index(@PathVariable int size, @PathVariable int page) {
        return iCategoryService.listCategoryParent(page,size);
    }

    @GetMapping(value = "/children/{id}/{size}/{page}")
    public ResponseEntity<?> children(@PathVariable Long id,@PathVariable int size, @PathVariable int page) {
        return iCategoryService.listCategoryChildren(id,page,size);
    }
}
