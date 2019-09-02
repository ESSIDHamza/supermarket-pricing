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
public class PricePerWeightStrategyTest {
	private ProductPricingStrategy productPricingStrategy;

	@Before
	public void setUp() {
		// Given a product where the lbs costs $1.99
		this.productPricingStrategy = new PricePerWeightStrategy();
	}

	@Test
	public void testGetTotalPrice() {
		final BigDecimal expected = BigDecimal.valueOf(4.975);
		final Product product = new Product();
		product.setPricePerUnit(BigDecimal.valueOf(1.99));
		product.setQuantityPerUnit(16); // the weight unit is the once
		// When a customer takes 40 onces
		final BigDecimal actual = this.productPricingStrategy.getTotalPrice(product, 40);
		// Then he should pay:
		// expected = (40 / 16) * 1.99 = $4.975
		assertEquals(expected, actual);
	}

}
