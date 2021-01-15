package com.cuellar.productcatalogproduct.web.api.rest.product;

import com.cuellar.productcatalogproduct.commons.dto.CategoryParentDto;
import com.cuellar.productcatalogproduct.models.entity.Product;
import com.cuellar.productcatalogproduct.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProductAPI {

    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/Product/{id}")
    public List<Product> indexProduct(@PathVariable Long id) {
        return iProductService.findByIdCategory(id);
    }
}
