package com.cuellar.productcatalogproduct.commons.dto;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long idProduct;
    private String name;
    private String description;
    private Long weight;
    private Long price;
    private String firstPhoto;
    private String secondPhoto;
    private String thirdPhoto;
}
