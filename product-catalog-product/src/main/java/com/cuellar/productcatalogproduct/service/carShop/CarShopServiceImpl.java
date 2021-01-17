package com.cuellar.productcatalogproduct.service.carShop;


import com.cuellar.productcatalogproduct.commons.dto.UserBasicDto;
import com.cuellar.productcatalogproduct.commons.request.AddCarShopDto;
import com.cuellar.productcatalogproduct.commons.response.CarShopResponseDto;
import com.cuellar.productcatalogproduct.commons.util.Util;
import com.cuellar.productcatalogproduct.models.entity.CarShop;
import com.cuellar.productcatalogproduct.models.entity.DetailCarShop;
import com.cuellar.productcatalogproduct.models.entity.User;
import com.cuellar.productcatalogproduct.repository.carShop.impl.ICarShopFacade;
import com.cuellar.productcatalogproduct.repository.product.impl.IProductFacade;
import com.cuellar.productcatalogproduct.repository.user.impl.IUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarShopServiceImpl implements ICarShopService {

    @Autowired
    private ICarShopFacade iCarShopFacade;

    @Autowired
    private IUserFacade iUserFacade;

    @Autowired
    private IProductFacade iProductFacade;


    @Override
    public Boolean addCarShop(AddCarShopDto addCarShopDto, String basic) {
        UserBasicDto userBasicDto = Util.getUser(basic);
        User user = iUserFacade.user(userBasicDto.getIdUser());
        CarShop carShopTMP = iCarShopFacade.findCarShop(user.getIdUser());
        List<DetailCarShop> detailCarShopsList = new ArrayList<>();
        DetailCarShop detailCarShop = new DetailCarShop();
        if (!ObjectUtils.isEmpty(carShopTMP)) {
            boolean status = true;
            for (int i = 0; i < carShopTMP.getDetailCarShops().size(); i++) {
                if (carShopTMP.getDetailCarShops().get(i).getProduct().getIdProduct() == addCarShopDto.getIdProduct()) {
                    carShopTMP.getDetailCarShops().get(i).setQuantity(addCarShopDto.getQuantity());
                    status = false;
                }
            }
            if (status) {
                detailCarShop.setCarShop(carShopTMP);
                detailCarShop.setQuantity(addCarShopDto.getQuantity());
                detailCarShop.setProduct(iProductFacade.findById(addCarShopDto.getIdProduct()));
                detailCarShopsList.add(detailCarShop);
                carShopTMP.getDetailCarShops().add(detailCarShop);
                carShopTMP.setUser(user);
            }
            return iCarShopFacade.addCarShop(carShopTMP);
        } else {
            CarShop carShop = new CarShop();
            detailCarShop.setCarShop(carShop);
            detailCarShop.setQuantity(addCarShopDto.getQuantity());
            detailCarShop.setProduct(iProductFacade.findById(addCarShopDto.getIdProduct()));
            detailCarShopsList.add(detailCarShop);
            carShop.setDetailCarShops(detailCarShopsList);
            carShop.setUser(user);

            return iCarShopFacade.addCarShop(carShop);
        }
    }

    @Override
    public ResponseEntity<?> findCarShop(String basic) {
        UserBasicDto userBasicDto = Util.getUser(basic);
        CarShop carShopTMP = iCarShopFacade.findCarShop(userBasicDto.getIdUser());
        List<CarShopResponseDto> responseList = new ArrayList<>();

        if (carShopTMP != null) {
            for (DetailCarShop detailCarShop : carShopTMP.getDetailCarShops()) {
                CarShopResponseDto carShopResponseDto = new CarShopResponseDto();
                carShopResponseDto.setIdCarShop(carShopTMP.getIdCarShop());
                carShopResponseDto.setQuantity(detailCarShop.getQuantity());
                carShopResponseDto.setProductDto(Util.changeProduct(detailCarShop.getProduct()));
                responseList.add(carShopResponseDto);
            }

        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @Override
    public Boolean deleteCarByID(Long idCar) {
        iCarShopFacade.deleteByIdCar(idCar);
        return true;
    }


}
