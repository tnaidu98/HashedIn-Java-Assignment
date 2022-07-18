package com.hashkart.cart.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_details")
public class CartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_DETAILS_ID_SEQ")
    @SequenceGenerator(
            name = "CART_DETAILS_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "prod_id")
    private int prodId;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "price")
    private double price;

    @Column(name = "qty")
    private int qty;
}