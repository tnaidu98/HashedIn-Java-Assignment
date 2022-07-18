package com.hashkart.product;

import com.hashkart.product.entities.ProductCategories;
import com.hashkart.product.entities.ProductDetails;
import com.hashkart.product.repositories.ProductCategoriesRepository;
import com.hashkart.product.repositories.ProductDetailsRepository;
import com.hashkart.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoriesApplicationTests {

	@Autowired
	private ProductService productService;

	@MockBean
	private ProductCategoriesRepository productCategoriesRepository;

	@MockBean
	private ProductDetailsRepository productDetailsRepository;

	@Test
	void showProductsTest() {
		ProductCategories productCategory1 = new ProductCategories(1,"Televisions");
		ProductCategories productCategory2 = new ProductCategories(2,"Mobiles");
		List<ProductCategories> productCategoriesList = new ArrayList<>();
		productCategoriesList.add(productCategory1);
		productCategoriesList.add(productCategory2);

		when(productCategoriesRepository.findAll()).thenReturn(productCategoriesList);
		assertEquals(productCategoriesList,productService.showProducts());

	}

	@Test
	void showProductsByCategoryTest() {
		String categoryName = "Televisions";
		int categoryId = 1;
		ProductCategories productCategory = new ProductCategories(1,"Televisions");
		ProductDetails productDetails1 = new ProductDetails(1,1,"Samsung 4K TV",35000.0,4.5,50);
		ProductDetails productDetails2 = new ProductDetails(2,1,"LG 4K TV",32000.0,4.2,50);
		List<ProductDetails> productDetailsList = new ArrayList<>();
		productDetailsList.add(productDetails1);
		productDetailsList.add(productDetails2);

		when(productCategoriesRepository.findByCategoryName(categoryName)).thenReturn(productCategory);
		when(productDetailsRepository.findByCategoryId(categoryId)).thenReturn(productDetailsList);
		assertEquals(productDetailsList,productService.showProductsByCategory("Televisions"));

	}

}
