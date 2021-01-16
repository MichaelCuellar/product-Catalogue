package com.cuellar.productcatalogproduct.service.product;

import com.cuellar.productcatalogproduct.models.entity.Product;
import org.springframework.data.domain.Page;


public interface IProductService {

    Page<Product> findByIdCategory(Long idCategory, int size, int page);
}
