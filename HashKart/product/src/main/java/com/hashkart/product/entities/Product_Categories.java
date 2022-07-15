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
@Table(name = "product_categories")
public class Product_Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_CATEGORIES_CATEGORY_ID_SEQ")
    @SequenceGenerator(
            name = "PRODUCT_CATEGORIES_CATEGORY_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "category_id")
    private int category_id;

    @Column(name = "category_name")
    private String category_name;

}