package com.cuellar.productcatalogproduct.service.product;

import com.cuellar.productcatalogproduct.models.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findByIdCategory(Long idCategory);
}
