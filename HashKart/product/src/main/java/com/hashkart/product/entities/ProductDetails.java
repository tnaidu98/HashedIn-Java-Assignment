package com.hashkart.product.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_details")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_DETAILS_PROD_ID_SEQ")
    @SequenceGenerator(
            name = "PRODUCT_DETAILS_PROD_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "prod_id")
    private int prodId;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "price")
    private double price;

    @Column(name = "rating")
    private double rating;

    @Column(name = "available_qty")
    private int availableQty;

}
