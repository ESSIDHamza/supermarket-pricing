package com.sgcib.supermarketpricing.services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.sgcib.supermarketpricing.entities.Product;

/**
 * @author Hamza ESSID
 * @version 0.0.1
 */
public class BuyXProductsGetYFreeStrategyTest {
	private ProductPricingStrategy productPricingStrategy;

	@Before
	public void setUp() {
		// Given a product with the pricing strategy of
		// "Buy 2 Products Get 1 Free"
		this.productPricingStrategy = new BuyXProductsGetYFreeStrategy(2, 1);
	}

	@Test
	public void testBuyTwoProductsGetOneFreeStrategy() {
		final BigDecimal expected = BigDecimal.valueOf(17.5);
		final Product product = new Product();
		product.setPricePerUnit(BigDecimal.valueOf(2.5)); // the price for one
															// is $2.5
		// When a customer takes 10 of this product
		final BigDecimal actual = this.productPricingStrategy.getTotalPrice(product, 10);
		// Then he should pay 7 units instead of 10
		// (expected = 7 * 2.5 = $17.5)
		assertEquals(expected, actual);
	}

}
