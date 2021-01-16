package com.cuellar.productcatalogproduct.service.product;

import com.cuellar.productcatalogproduct.models.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;


public interface IProductService {

    ResponseEntity<?> findByIdCategory(Long idCategory, int size, int page);
}
