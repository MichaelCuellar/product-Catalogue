package com.cuellar.productcatalogproduct.repository.product.impl;

import com.cuellar.productcatalogproduct.models.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProductFacade {

    boolean addProduct(Product product);
    Page<Product> findProductByCategory(Long idCategory, Pageable pageable);
    Product findById(Long idProduct);
}
