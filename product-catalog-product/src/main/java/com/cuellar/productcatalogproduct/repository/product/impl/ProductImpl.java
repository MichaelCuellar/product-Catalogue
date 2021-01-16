package com.cuellar.productcatalogproduct.repository.product.impl;

import com.cuellar.productcatalogproduct.models.entity.Product;
import com.cuellar.productcatalogproduct.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


@Service
public class ProductImpl implements IProductFacade {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public boolean addProduct(Product product) {
        return !ObjectUtils.isEmpty(iProductRepository.save(product));
    }

    @Override
    public Page<Product> findProductByCategory(Long idCategory, Pageable pageable) {
        return iProductRepository.findProductByCategory(idCategory,pageable);
    }
}
