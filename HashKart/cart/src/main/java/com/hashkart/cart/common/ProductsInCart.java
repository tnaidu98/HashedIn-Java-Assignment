package com.hashkart.cart.common;

import com.hashkart.cart.entities.Cart_Details;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ProductsInCart {

    List<Cart_Details> cart_detailsList;

    double totalPrice;

}
