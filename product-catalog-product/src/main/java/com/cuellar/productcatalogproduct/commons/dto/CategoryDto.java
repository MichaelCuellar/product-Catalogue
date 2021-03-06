package com.cuellar.productcatalogproduct.commons.dto;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long idCategoryParent;
    private String nameCategoryParent;
    private String photoCategoryParent;
    private boolean lastLevel;
}
