package com.cuellar.productcatalogproduct.repository.carShop.impl;


import com.cuellar.productcatalogproduct.models.entity.CarShop;
import com.cuellar.productcatalogproduct.repository.carShop.ICarShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CarShopImpl implements ICarShopFacade{

    @Autowired
    private ICarShopRepository iCarShopRepository;

    @Override
    public Boolean addCarShop(CarShop carShop) {
        return !ObjectUtils.isEmpty(iCarShopRepository.save(carShop));
    }

    @Override
    public CarShop findCarShop(Long user) {
        return iCarShopRepository.findCarShopByUser(user);
    }

    @Override
    public void deleteByIdCar(Long idCar) {
        iCarShopRepository.deleteById(idCar);
    }
}
