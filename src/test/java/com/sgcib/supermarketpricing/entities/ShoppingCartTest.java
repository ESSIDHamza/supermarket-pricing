package com.sgcib.supermarketpricing.entities;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.sgcib.supermarketpricing.entities.Product;
import com.sgcib.supermarketpricing.services.BuyXProductsGetYFreeStrategy;
import com.sgcib.supermarketpricing.services.PricePerUnitStrategy;
import com.sgcib.supermarketpricing.services.PricePerWeightStrategy;
import com.sgcib.supermarketpricing.services.XProductsForYDollarStrategy;

/**
 * @author Hamza ESSID
 * @version 0.0.1
 */
public class ShoppingCartTest {
	private ShoppingCart shoppingCart;

	@Before
	public void setUp() {
		this.mockShoppingCart();
	}

	@Test
	public void testGetTotalPrice() {
		final BigDecimal expected = BigDecimal.valueOf(33.475);
		final BigDecimal actual = this.shoppingCart.getTotalPrice();
		assertEquals(expected, actual);
	}

	private void mockShoppingCart() {
		this.shoppingCart = new ShoppingCart();

		final Product p1 = new Product();
		p1.setPricePerUnit(BigDecimal.valueOf(0.5));
		p1.setPricingStrategy(new XProductsForYDollarStrategy(3, BigDecimal.ONE));

		final Product p2 = new Product();
		p2.setPricePerUnit(BigDecimal.valueOf(1.99));
		p2.setQuantityPerUnit(16);
		p2.setPricingStrategy(new PricePerWeightStrategy());

		final Product p3 = new Product();
		p3.setPricePerUnit(BigDecimal.valueOf(2.5));
		p3.setPricingStrategy(new BuyXProductsGetYFreeStrategy(2, 1));

		final Product p4 = new Product();
		p4.setPricePerUnit(BigDecimal.valueOf(1.5));
		p4.setPricingStrategy(new PricePerUnitStrategy());

		this.shoppingCart.addProduct(p1, 10);
		this.shoppingCart.addProduct(p2, 40);
		this.shoppingCart.addProduct(p3, 10);
		this.shoppingCart.addProduct(p4, 5);
	}

}
