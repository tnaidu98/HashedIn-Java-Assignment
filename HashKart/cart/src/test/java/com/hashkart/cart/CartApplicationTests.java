package com.hashkart.cart;

import com.hashkart.cart.common.ProductsInCart;
import com.hashkart.cart.entities.CartDetails;
import com.hashkart.cart.repositories.CartRepository;
import com.hashkart.cart.service.CartService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class CartApplicationTests {

	@Autowired
	private CartService cartService;

	@MockBean
	private CartRepository cartRepository;

	@Test
	public void addProductToCartTest() {
		CartDetails productDetails = new CartDetails(15,1,1,"Samsung 4K TV",35000.0,2);
		when(cartRepository.save(productDetails)).thenReturn(productDetails);
		assertEquals("Product added to Cart",cartService.addProductToCart(productDetails));
	}

	@Test
	public void getProductsInCart() {
		int userId = 1;
		CartDetails cartDetails1 = new CartDetails(15,1,1,"Samsung 4K TV",35000.0,2);
		CartDetails cartDetails2 = new CartDetails(16,1,1,"Samsung 4K TV",35000.0,2);
		List<CartDetails> cartDetailsList = new ArrayList<>();
		cartDetailsList.add(cartDetails1);
		cartDetailsList.add(cartDetails2);
		when(cartRepository.findAllByUserId(userId)).thenReturn(cartDetailsList);
		when(cartRepository.findTotalPrice(userId)).thenReturn(70000.00);
		assertEquals(2,cartService.getProductsInCart(1).getCartDetailsList().size());
		assertEquals(70000.00,cartService.getProductsInCart(1).getTotalPrice());
	}




}
