package com.cuellar.productcatalogproduct.commons.response;

import com.cuellar.productcatalogproduct.commons.dto.CategoryDto;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {

    private List<CategoryDto> categoryDtoList;
    private Long totalItems;
    private int totalPages;
}
