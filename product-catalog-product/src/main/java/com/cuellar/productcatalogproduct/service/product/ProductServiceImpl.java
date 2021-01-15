package com.cuellar.productcatalogproduct.service.product;

import com.cuellar.productcatalogproduct.models.entity.Product;
import com.cuellar.productcatalogproduct.repository.product.impl.IProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductFacade iProductFacade;

    @Override
    public List<Product> findByIdCategory(Long idCategory) {
        return iProductFacade.findProductByCategory(idCategory);
    }
}
