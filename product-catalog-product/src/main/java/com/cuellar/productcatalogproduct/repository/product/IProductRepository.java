package com.cuellar.productcatalogproduct.repository.product;

import com.cuellar.productcatalogproduct.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT c FROM Product c WHERE c.category.idCategory =:idCategory")
    List<Product> findProductByCategory(@Param("idCategory") Long idCategory);

}
