package com.sgcib.supermarketpricing.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import com.sgcib.supermarketpricing.services.ProductPricingStrategy;

/**
 * This class represents a real-world product in a supermarket.
 * 
 * @author Hamza ESSID
 * @version 0.0.1
 *
 */

@SuppressWarnings("serial")
public class Product implements Serializable {

	private Integer productId;
	private String productLabel;
	private BigDecimal pricePerUnit;
	private int quantityPerUnit;
	private ProductPricingStrategy pricingStrategy;

	public Product() {
		super();
	}

	public Product(final ProductPricingStrategy pricingStrategy) {
		this.pricingStrategy = pricingStrategy;
	}

	/**
	 * Gets this product total quantity price according to the strategy set.
	 */
	public BigDecimal getTotalPrice(final int totalQuantity) {
		return this.pricingStrategy.getTotalPrice(this, totalQuantity);
	}

	public Product(Integer productId, String productLabel, BigDecimal pricePerUnit, int quantityPerUnit,
			ProductPricingStrategy pricingStrategy) {
		super();
		this.productId = productId;
		this.productLabel = productLabel;
		this.pricePerUnit = pricePerUnit;
		this.quantityPerUnit = quantityPerUnit;
		this.pricingStrategy = pricingStrategy;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductLabel() {
		return productLabel;
	}

	public void setProductLabel(String productLabel) {
		this.productLabel = productLabel;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public int getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(int quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public ProductPricingStrategy getPricingStrategy() {
		return pricingStrategy;
	}

	public void setPricingStrategy(ProductPricingStrategy pricingStrategy) {
		this.pricingStrategy = pricingStrategy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pricePerUnit == null) ? 0 : pricePerUnit.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productLabel == null) ? 0 : productLabel.hashCode());
		result = prime * result + quantityPerUnit;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (pricePerUnit == null) {
			if (other.pricePerUnit != null)
				return false;
		} else if (!pricePerUnit.equals(other.pricePerUnit))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productLabel == null) {
			if (other.productLabel != null)
				return false;
		} else if (!productLabel.equals(other.productLabel))
			return false;
		if (quantityPerUnit != other.quantityPerUnit)
			return false;
		return true;
	}

}
