package com.cuellar.productcatalogproduct.repository.carShop.impl;


import com.cuellar.productcatalogproduct.models.entity.CarShop;

public interface ICarShopFacade {

    Boolean addCarShop(CarShop carShop);
    CarShop findCarShop(Long user);
    void deleteByIdCar(Long idCar);
}
