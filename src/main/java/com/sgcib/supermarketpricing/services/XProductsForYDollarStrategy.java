package com.sgcib.supermarketpricing.services;

import java.math.BigDecimal;

import com.sgcib.supermarketpricing.entities.Product;

/**
 * For example: Buy 3 products for $1 (productsNumber = 3 and price = 1).
 * 
 * @author Hamza ESSID
 * @version 0.0.1
 * 
 */
public class XProductsForYDollarStrategy implements ProductPricingStrategy {
	private int productsNumber;
	private BigDecimal price;

	public XProductsForYDollarStrategy() {
		super();
	}

	public XProductsForYDollarStrategy(int productsNumber, BigDecimal price) {
		super();
		this.productsNumber = productsNumber;
		this.price = price;
	}

	@Override
	public BigDecimal getTotalPrice(final Product product, final int totalQuantity) {
		return product.getPricePerUnit().multiply(BigDecimal.valueOf(totalQuantity % this.productsNumber))
				.add(this.price.multiply(BigDecimal.valueOf(totalQuantity / this.productsNumber)));
	}

	public int getProductsNumber() {
		return productsNumber;
	}

	public void setProductsNumber(int productsNumber) {
		this.productsNumber = productsNumber;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
