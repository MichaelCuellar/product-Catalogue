package com.cuellar.productcatalogproduct.models.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @Column(name = "id_category")
    private Long idCategory;
    private String name;
    private String photo;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category parentCategory;
    @OneToMany(mappedBy = "parentCategory")
    private List<Category> children;

}
