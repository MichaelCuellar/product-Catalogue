package com.cuellar.productcatalogproduct.service.product;

import com.cuellar.productcatalogproduct.commons.dto.ProductDto;
import com.cuellar.productcatalogproduct.commons.response.ProductResponseDto;
import com.cuellar.productcatalogproduct.models.entity.Category;
import com.cuellar.productcatalogproduct.models.entity.Product;
import com.cuellar.productcatalogproduct.repository.product.impl.IProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductFacade iProductFacade;

    @Override
    public ResponseEntity<?> findByIdCategory(Long idCategory, int size, int page) {
        Page<Product> productsList = iProductFacade.findProductByCategory(idCategory, PageRequest.of(page, size));
        List<ProductDto> productListTmp = new ArrayList<>();
        for (Product productDto : productsList) {
            productListTmp.add(changeProduct(productDto));
        }
        ProductResponseDto response = new ProductResponseDto();
        response.setDtoList(productListTmp);
        response.setTotalItems(productsList.getTotalElements());
        response.setTotalPages(productsList.getTotalPages());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ProductDto changeProduct(Product product){
        ProductDto responseDto = new ProductDto();
        responseDto.setIdProduct(product.getIdProduct());
        responseDto.setName(product.getName());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setWeight(product.getWeight());
        responseDto.setFirstPhoto(product.getFirstPhoto());
        responseDto.setSecondPhoto(product.getSecondPhoto());
        responseDto.setThirdPhoto(product.getThirdPhoto());
        return responseDto;
    }
}
