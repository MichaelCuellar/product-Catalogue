package com.cuellar.productcatalogproduct.repository.carShop;


import com.cuellar.productcatalogproduct.models.entity.CarShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICarShopRepository extends JpaRepository<CarShop,Long> {

    @Query("SELECT c FROM CarShop c WHERE c.user.idUser =:user")
    CarShop findCarShopByUser(@Param("user") Long user);

}
