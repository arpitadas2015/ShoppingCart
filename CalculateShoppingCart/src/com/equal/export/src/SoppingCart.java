/**
 * 
 */
package com.equal.export.src;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * This program will calculate and print shopping cart details
 * @author arpitadas
 *
 */

public class SoppingCart {

	public static SoppingCart soppingCart = null;
	public Double cartPrice= new Double(0.0);
	public static String cartPriceRoundOff;
	private static DecimalFormat df2 = new DecimalFormat(".##");
	
	public Double getCartPrice() {
		return cartPrice;
	}


	public static String getCartPriceRoundOff() {
		return cartPriceRoundOff;
	}


	public void setCartPriceRoundOff(String cartPriceRoundOff) {
		SoppingCart.cartPriceRoundOff = cartPriceRoundOff;
	}


	public void setCartPrice(Double cartPrice) { 
		this.cartPrice = cartPrice;
	}
	
	public SoppingCart() {
	}

	/**
	 * Constructor to create a shopping cart this product and quantity
	 * @param product
	 * @param quantity
	 */
	public SoppingCart(Product product, int quantity){
		cartPrice=new Double(0.0);
		if ((quantity != 0)){
			
		}
		if((soppingCart==null)){
			soppingCart=new SoppingCart();
			cartPrice = soppingCart.addProductToCart(product,quantity);
			soppingCart.setCartPrice(cartPrice);
			soppingCart.setCartPriceRoundOff(roundOff(cartPrice));
			
		}
		else{
		if((quantity != 0))	{
		Double cartPrice1 = soppingCart.addProductToCart(product,quantity);
		cartPrice=soppingCart.getCartPrice() + cartPrice1;
		soppingCart.setCartPrice(cartPrice);
		soppingCart.setCartPriceRoundOff(roundOff(cartPrice));
		}
		}
	}
	
	/**
	 * This API or method is to create a shopping cart with product details
	 * @param product
	 * @return Product
	 */
	
	public Product createShoppingCart(Product product){
		
		if(product == null){
			return new Product();
		}
		
		Product newProduct = new Product();
		newProduct.setName(product.getName());
		newProduct.setProductType(product.getProductType());
		newProduct.setUnitPrice(product.getUnitPrice());
		return newProduct;
	}
	
	/**
	 * This API or method is to add a product along with its quantity to an existing shopping cart
	 * @param product
	 * @param quantity
	 * @return cartPrice
	 */
	
	public Double addProductToCart(Product product, int quantity){
		Product productNew= createShoppingCart(product);
		Double cartPrice= (productNew.getUnitPrice() * quantity);
		return cartPrice;
	}
	
	/**
	 * This API or method is to calculate the total tax for an existing shopping cart
	 * @param soppingCart
	 * @return taxAmount
	 */
	public  double calculateTotalWithTax(SoppingCart soppingCart){
		Double tax=new Double(0.0);
		Double cartPrice = soppingCart.getCartPrice();
		if(cartPrice>0.0){
			tax = (cartPrice * 12.5 )/100;
		}
		
		return tax;
	}
	
	/**
	 * THis API or method is for rounding off any double value till 2 decimal
	 * @param cartPrice
	 * @return roundedValueTill2Decimal
	 */
	public String roundOff(Double cartPrice){
		df2.setRoundingMode(RoundingMode.HALF_DOWN);
		return df2.format(cartPrice);
	}
	
	public void resetShoppingCart(){
		SoppingCart soppingCart=null;
	}
}
