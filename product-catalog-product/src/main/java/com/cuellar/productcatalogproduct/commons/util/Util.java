package com.cuellar.productcatalogproduct.commons.util;



import com.cuellar.productcatalogproduct.commons.dto.ProductDto;
import com.cuellar.productcatalogproduct.commons.dto.UserBasicDto;
import com.cuellar.productcatalogproduct.models.entity.Product;

import java.util.Base64;


public class Util {

    public static UserBasicDto getUser(String basic) {
        byte[] userDetail = Base64.getDecoder().decode(basic);
        String userDecode = new String(userDetail);
        Long idUser = Long.valueOf(userDecode.split(":")[0]);
        String idCredentials = userDecode.split(":")[1];
        return UserBasicDto.builder().idUser(idUser).credentials(idCredentials).build();
    }

    public static ProductDto changeProduct(Product product){
        ProductDto responseDto = new ProductDto();
        responseDto.setIdProduct(product.getIdProduct());
        responseDto.setName(product.getName());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setWeight(product.getWeight());
        responseDto.setFirstPhoto(product.getFirstPhoto());
        responseDto.setSecondPhoto(product.getSecondPhoto());
        responseDto.setThirdPhoto(product.getThirdPhoto());
        return responseDto;
    }
}
