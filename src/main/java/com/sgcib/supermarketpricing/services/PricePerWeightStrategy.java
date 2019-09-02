package com.sgcib.supermarketpricing.services;

import java.math.BigDecimal;

import com.sgcib.supermarketpricing.entities.Product;

/**
 * For example: $1.99 per lbs.
 * 
 * @author Hamza ESSID
 * @version 0.0.1
 *
 */
public class PricePerWeightStrategy implements ProductPricingStrategy {

	@Override
	public BigDecimal getTotalPrice(Product product, int totalQuantity) {
		return product.getPricePerUnit()
				.multiply(BigDecimal.valueOf((double) totalQuantity / product.getQuantityPerUnit()));
	}

}
