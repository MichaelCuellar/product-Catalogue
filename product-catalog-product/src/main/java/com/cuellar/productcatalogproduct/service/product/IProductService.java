package com.cuellar.productcatalogproduct.service.product;

import org.springframework.http.ResponseEntity;


public interface IProductService {

    ResponseEntity<?> findByIdCategory(Long idCategory, int size, int page);

    ResponseEntity<?> findProductById(Long idProduct);
}
