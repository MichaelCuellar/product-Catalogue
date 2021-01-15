package com.cuellar.productcatalogproduct.repository.category;

import com.cuellar.productcatalogproduct.models.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Long> {

    @Query("SELECT c FROM Category c WHERE c.parentCategory IS NULL")
    List<Category> findCategoryParent();

    @Query("SELECT c FROM Category c WHERE c.parentCategory.idCategory =:idParent")
    List<Category> findCategoryByChildren(@Param("idParent") Long idParent);
}
