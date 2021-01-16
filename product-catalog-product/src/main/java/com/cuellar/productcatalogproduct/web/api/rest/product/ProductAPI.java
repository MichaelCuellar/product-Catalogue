package com.cuellar.productcatalogproduct.web.api.rest.product;

import com.cuellar.productcatalogproduct.models.entity.Product;
import com.cuellar.productcatalogproduct.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProductAPI {

    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/Product/{id}/{size}/{page}")
    public Page<Product> indexProduct(@PathVariable Long id, @PathVariable int size, @PathVariable int page) {
        return iProductService.findByIdCategory(id,size,page);
    }
}
