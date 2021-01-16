package com.cuellar.productcatalogproduct.commons.response;

import com.cuellar.productcatalogproduct.commons.dto.ProductDto;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private List<ProductDto> dtoList;
    private Long totalItems;
    private int totalPages;
}
