package com.cuellar.productcatalogproduct.service.category;



import org.springframework.http.ResponseEntity;


public interface ICategoryService {

    ResponseEntity<?> listCategoryParent(int page, int size);

    ResponseEntity<?> listCategoryChildren(Long idParent,int page, int size);
}
