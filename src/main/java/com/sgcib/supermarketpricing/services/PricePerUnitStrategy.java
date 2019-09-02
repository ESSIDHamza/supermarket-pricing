package com.sgcib.supermarketpricing.services;

import java.math.BigDecimal;

import com.sgcib.supermarketpricing.entities.Product;

/**
 * When there is no special pricing strategy. For example: When purchasing 3
 * products and the unit price is $1.5, then the total price is $4.5
 * 
 * @author Hamza ESSID
 * @version 0.0.1
 *
 */
public class PricePerUnitStrategy implements ProductPricingStrategy {

	@Override
	public BigDecimal getTotalPrice(final Product product, final int totalQuantity) {
		return BigDecimal.ZERO;
	}

}
