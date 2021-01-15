package com.cuellar.productcatalogproduct.repository.product.impl;

import com.cuellar.productcatalogproduct.models.entity.Product;

import java.util.List;

public interface IProductFacade {

    boolean addProduct(Product product);
    List<Product> findProductByCategory(Long idCategory);
}
