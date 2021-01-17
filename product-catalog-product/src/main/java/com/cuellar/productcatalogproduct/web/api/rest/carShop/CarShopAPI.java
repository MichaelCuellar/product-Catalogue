package com.cuellar.productcatalogproduct.web.api.rest.carShop;


import com.cuellar.productcatalogproduct.commons.request.AddCarShopDto;
import com.cuellar.productcatalogproduct.service.carShop.ICarShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CarShopAPI {

    @Autowired
    private ICarShopService iCarShopService;

    @PostMapping(value = "/addCarShop")
    public Boolean addCarShop(@RequestBody AddCarShopDto addCarShopDto, @RequestHeader String basic){
        return iCarShopService.addCarShop(addCarShopDto,basic);
    }

    @GetMapping(value = "/carShop")
    public ResponseEntity<?> findCarShop(@RequestHeader String basic){
        return iCarShopService.findCarShop(basic);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean deleteCarShop(@PathVariable Long id){
        return iCarShopService.deleteCarByID(id);
    }

}
