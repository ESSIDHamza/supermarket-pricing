package com.sgcib.supermarketpricing.services;

import java.math.BigDecimal;

import com.sgcib.supermarketpricing.entities.Product;

/**
 * For example: Buy 2 products get 1 free (productsNumber = 2 and freeProducts =
 * 1).
 * 
 * @author Hamza ESSID
 * @version 0.0.1
 *
 */
public class BuyXProductsGetYFreeStrategy implements ProductPricingStrategy {
	private int productsNumber;
	private int freeProducts;

	public BuyXProductsGetYFreeStrategy() {
		super();
	}

	public BuyXProductsGetYFreeStrategy(int productsNumber, int freeProducts) {
		super();
		this.productsNumber = productsNumber;
		this.freeProducts = freeProducts;
	}

	@Override
	public BigDecimal getTotalPrice(final Product product, final int totalQuantity) {
		return product.getPricePerUnit()
				.multiply(BigDecimal
						.valueOf((totalQuantity / (this.productsNumber + this.freeProducts) * this.productsNumber)
								+ (totalQuantity % (this.productsNumber + this.freeProducts))));
	}

	public int getProductsNumber() {
		return productsNumber;
	}

	public void setProductsNumber(int productsNumber) {
		this.productsNumber = productsNumber;
	}

	public int getFreeProducts() {
		return freeProducts;
	}

	public void setFreeProducts(int freeProducts) {
		this.freeProducts = freeProducts;
	}

}
