/**
 * 
 */
package com.equal.export.src;

/**
 * This class in define to create new product for shopping care application
 * @author arpitadas
 * 
 */
public class Product {
	
	private String name;
	private double unitPrice;
	private String productType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	

}
