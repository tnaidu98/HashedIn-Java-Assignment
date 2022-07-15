package com.hashkart.product.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class Product_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_DETAILS_PROD_ID_SEQ")
    @SequenceGenerator(
            name = "PRODUCT_DETAILS_PROD_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "prod_id")
    private int prod_id;

    @Column(name = "category_id")
    private int category_id;

    @Column(name = "prod_name")
    private String prod_name;

    @Column(name = "price")
    private double price;

    @Column(name = "rating")
    private double rating;

    @Column(name = "available_qty")
    private int available_qty;

}
