package org.example.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest{
    String product = "Sauce Labs Bolt T-Shirt";

    @Test
    public void checkAddedProductToCart(){
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.addToCart(product);
        cartPage.open();
        Assert.assertEquals(cartPage.productNameCheck(),product);
    }

    @Test
    public void removeAddedProductFromCart(){
        cartPage.addProductToCartAsValid(product);
        cartPage.open();
        cartPage.deleteProductFromCart();
        assertTrue(driver.findElement(By.xpath("//div[@class='inventory_item_name']")).isDisplayed(),"Not displayed");
    }

    @Test
    public void navigateToCheckoutPage(){
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.open();
        cartPage.goToCheckout();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='title']")).getText(),"Checkout: Your Information");
    }

    @Test
    public void returnToContinueShopping(){
        loginPage.open();
        loginPage.loginAsValidUser();
        cartPage.open();
        cartPage.continueShopping();
        driver.findElement(By.cssSelector(".title"));
        assertTrue(productsPage.getTITLE().isDisplayed(), "User not return to product cart");
    }

    @Test
    public void checkAddedProductName(){
        loginPage.open();
        loginPage.loginAsValidUser();
        cartPage.open();
        assertEquals(cartPage.checkTitle(),"YOUR CART");
    }
}
