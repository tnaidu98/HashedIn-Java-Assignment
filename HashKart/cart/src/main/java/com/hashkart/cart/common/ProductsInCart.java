package com.hashkart.cart.common;

import com.hashkart.cart.entities.CartDetails;
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

    List<CartDetails> cartDetailsList;

    double totalPrice;

}
