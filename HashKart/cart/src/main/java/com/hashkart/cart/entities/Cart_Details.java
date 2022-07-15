package com.hashkart.cart.entities;

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
@Table(name = "cart_details")
public class Cart_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_DETAILS_ID_SEQ")
    @SequenceGenerator(
            name = "CART_DETAILS_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "prod_id")
    private int prod_id;

    @Column(name = "prod_name")
    private String prod_name;

    @Column(name = "price")
    private double price;

    @Column(name = "qty")
    private int qty;
}