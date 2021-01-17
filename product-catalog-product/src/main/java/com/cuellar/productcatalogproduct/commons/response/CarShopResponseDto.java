package com.cuellar.productcatalogproduct.commons.response;

import com.cuellar.productcatalogproduct.commons.dto.ProductDto;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarShopResponseDto {

    private Long quantity;
    private ProductDto productDto;
    private Long idCarShop;
}
