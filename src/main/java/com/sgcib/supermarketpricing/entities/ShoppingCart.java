package com.sgcib.supermarketpricing.entities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a real-world shopping cart in a supermarket to which we
 * can add or remove products and get the total price of the products within.
 * 
 * @author Hamza ESSID
 * @version 0.0.1
 *
 */
public class ShoppingCart {
	private Map<Product, Integer> productsAndTotalQuantities;

	public ShoppingCart() {
		this.productsAndTotalQuantities = new HashMap<>();
	}

	/**
	 * @param addendQuantity
	 *            positive when we intend to add, negative otherwise (adding
	 *            negative quantity means quite simply subtracting it)
	 */
	public void addProduct(final Product product, final int addendQuantity) {
	}

	/**
	 * Removes product from this shopping cart.
	 */
	public void removeProduct(final Product product) {
	}

	/**
	 * Calculates the customer's shopping cart total price.
	 */
	public BigDecimal getTotalPrice() {
		return BigDecimal.ZERO;
	}

}
