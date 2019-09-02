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
public class PricePerUnitStrategyTest {
	private ProductPricingStrategy productPricingStrategy;

	@Before
	public void setUp() {
		// Given a product with no special pricing strategy
		this.productPricingStrategy = new PricePerUnitStrategy();
	}

	@Test
	public void testGetTotalPrice() {
		final BigDecimal expected = BigDecimal.valueOf(7.5);
		final Product product = new Product();
		product.setPricePerUnit(BigDecimal.valueOf(1.5)); // the price for one
															// is $1.5
		// When a customer buys 5 of this product
		final BigDecimal actual = this.productPricingStrategy.getTotalPrice(product, 5);
		// Then he should pay:
		// expected = 5 * 1.5 = $7.5
		assertEquals(expected, actual);
	}

}
