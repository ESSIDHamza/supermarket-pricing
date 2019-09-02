package com.sgcib.supermarketpricing.entities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

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
		Optional.ofNullable(this.productsAndTotalQuantities.get(product)).ifPresent(augendQuantity -> {
			this.productsAndTotalQuantities.put(product, augendQuantity + addendQuantity);
		});

		if (Objects.isNull(this.productsAndTotalQuantities.get(product))) {
			this.productsAndTotalQuantities.put(product, addendQuantity);
		}
	}

	/**
	 * Removes product from this shopping cart.
	 */
	public void removeProduct(final Product product) {
		this.productsAndTotalQuantities.remove(product);
	}

	/**
	 * Calculates the customer's shopping cart total price.
	 */
	public BigDecimal getTotalPrice() {
		return this.productsAndTotalQuantities.keySet().stream()
				.map(boughtProduct -> boughtProduct.getTotalPrice(productsAndTotalQuantities.get(boughtProduct)))
				.reduce((a, b) -> a.add(b)).get();
	}

}
