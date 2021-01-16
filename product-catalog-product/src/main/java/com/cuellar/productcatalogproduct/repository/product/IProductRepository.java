package com.cuellar.productcatalogproduct.repository.product;

import com.cuellar.productcatalogproduct.models.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT c FROM Product c WHERE c.category.idCategory =:idCategory")
    Page<Product> findProductByCategory(@Param("idCategory") Long idCategory, Pageable pageable);

}
