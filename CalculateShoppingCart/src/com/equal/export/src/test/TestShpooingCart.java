/**
 * 
 */
package com.equal.export.src.test;

import java.lang.reflect.Field;

import org.junit.Test;

import com.equal.export.src.Product;
import com.equal.export.src.SoppingCart;

import junit.framework.Assert;

/**
 * This is a test class to test shopping cart program
 * @author arpitadas
 *
 */
public class TestShpooingCart {

	@Test
	public void test() {
		Product product = new Product();
		product.setName("Dove Soap");
		product.setProductType("Soap");
		product.setUnitPrice(39.99);
		@SuppressWarnings("unused")
		SoppingCart  soppingCart = new SoppingCart(product, 5);
		Assert.assertEquals("Shpooing cart total price","199.95", SoppingCart.getCartPriceRoundOff());
		System.out.println("Cart Price: " + SoppingCart.getCartPriceRoundOff());
	}
	
	
	@Test
	public void test2() {
		Product product = new Product();
		product.setName("Dove Soap");
		product.setProductType("Soap");
		product.setUnitPrice(39.99);
		SoppingCart.soppingCart=null;
		SoppingCart  soppingCart1 = new SoppingCart(product, 5);
		soppingCart1 = new SoppingCart(product, 3);
		Assert.assertEquals("Shpooing cart total price","319.92", soppingCart1.getCartPriceRoundOff());
		System.out.println("Cart Price: " + soppingCart1.getCartPriceRoundOff());
	}

}
