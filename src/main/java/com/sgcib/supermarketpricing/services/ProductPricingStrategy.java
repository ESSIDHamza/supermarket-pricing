package com.sgcib.supermarketpricing.services;

import java.math.BigDecimal;

import com.sgcib.supermarketpricing.entities.Product;

/**
 * All classes that perform pricing calculus according to a certain strategy
 * should implement this interface.
 * 
 * @author Hamza ESSID
 * @version 0.0.1
 *
 */
public interface ProductPricingStrategy {

	/**
	 * Gets the product total quantity price.
	 */
	BigDecimal getTotalPrice(final Product product, final int totalQuantity);

}
