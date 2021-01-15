package com.cuellar.productcatalogproduct.models.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;
    private String name;
    private String description;
    private Long weight;
    private Long price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    @Column(name = "first_photo")
    private String firstPhoto;
    @Column(name = "second_photo")
    private String secondPhoto;
    @Column(name = "third_photo")
    private String thirdPhoto;

}
