package com.cuellar.productcatalogproduct.commons.request;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddCarShopDto {

    private Long idProduct;
    private Long quantity;
}
