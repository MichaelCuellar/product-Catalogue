package com.cuellar.productcatalogproduct.web.api.rest.product;

import com.cuellar.productcatalogproduct.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProductAPI {

    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/product/{id}/{size}/{page}")
    public ResponseEntity<?> indexProduct(@PathVariable Long id, @PathVariable int size, @PathVariable int page) {
        return iProductService.findByIdCategory(id,size,page);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<?> findProduct(@PathVariable Long id) {
        return iProductService.findProductById(id);
    }
}
