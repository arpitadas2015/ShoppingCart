/**
 * 
 */
package com.equal.export.src.test;

import org.junit.BeforeClass;
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
	
	@BeforeClass
	public static void setup() throws Exception
	{
		SoppingCart.soppingCart=null;
	}

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
	
	@Test
	public void test3() {
		Product product = new Product();
		product.setName("Dove Soap");
		product.setProductType("Soap");
		product.setUnitPrice(39.99);
		SoppingCart.soppingCart=null;
		SoppingCart  soppingCart1 = new SoppingCart(product, 2);
		Product product2 = new Product();
		product2.setName("Axe Deo");
		product2.setProductType("Deo");
		product2.setUnitPrice(99.99);
		soppingCart1 = new SoppingCart(product2, 2);
		Double tax = soppingCart1.calculateTotalWithTax(soppingCart1);
		soppingCart1.setCartPriceWithTax(soppingCart1.getCartPrice()+tax);
		soppingCart1.setCartPriceRoundOff(soppingCart1.roundOff(soppingCart1.getCartPriceWithTax()));
		Assert.assertEquals("Shpooing cart total price","314.96", soppingCart1.getCartPriceRoundOff());
		System.out.println("Cart Price: " + soppingCart1.getCartPriceRoundOff());
	}

}
