package com.cuellar.productcatalogproduct.service.carShop;


import com.cuellar.productcatalogproduct.commons.request.AddCarShopDto;
import org.springframework.http.ResponseEntity;

public interface ICarShopService {

    Boolean addCarShop(AddCarShopDto addCarShopDto, String basic);

    ResponseEntity<?> findCarShop(String basic);

    Boolean deleteCarByID(Long idCar);

}
