package com.cuellar.productcatalogproduct.models.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detail_car_shop")
public class DetailCarShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail_car_shop")
    private Long idDetailCarShop;
    private Long quantity;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_CAR_SHOP", nullable = false)
    private CarShop carShop;
    @ManyToOne()
    private Product product;
}
