package com.cuellar.productcatalogproduct.service.product;

import com.cuellar.productcatalogproduct.models.entity.Product;
import com.cuellar.productcatalogproduct.repository.product.impl.IProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductFacade iProductFacade;

    @Override
    public Page<Product> findByIdCategory(Long idCategory, int size, int page) {

        return iProductFacade.findProductByCategory(idCategory, PageRequest.of(page, size));
    }
}
