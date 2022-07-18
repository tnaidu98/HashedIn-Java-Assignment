package com.hashkart.product.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_categories")
public class ProductCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_CATEGORIES_CATEGORY_ID_SEQ")
    @SequenceGenerator(
            name = "PRODUCT_CATEGORIES_CATEGORY_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

}