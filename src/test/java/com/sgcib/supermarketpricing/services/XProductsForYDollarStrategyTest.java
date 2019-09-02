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
public class XProductsForYDollarStrategyTest {
	private ProductPricingStrategy productPricingStrategy;

	@Before
	public void setUp() {
		// Given a product with the pricing strategy of
		// "3 Products for $1"
		this.productPricingStrategy = new XProductsForYDollarStrategy(3, BigDecimal.ONE);
	}

	@Test
	public void testThreeProductsForOneDollarStrategy() {
		final BigDecimal expected = BigDecimal.valueOf(3.5);
		final Product product = new Product();
		product.setPricePerUnit(BigDecimal.valueOf(0.5)); // the price for one
															// is $0.5
		// When a customer takes 10 of this product
		final BigDecimal actual = this.productPricingStrategy.getTotalPrice(product, 10);
		// Then he should pay 9 units for $3
		// and the last one for its original price ($0.5)
		// expected = 3 + 0.5 = $3.5
		assertEquals(expected, actual);
	}

}
