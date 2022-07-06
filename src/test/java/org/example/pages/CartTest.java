package org.example.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        cartPage.addProductToCartAsValid("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.deleteProductFromCart();
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
        productsPage.open();
        cartPage.continueShoppingButton.click();
        driver.findElement(By.cssSelector(".title"));
        assertTrue(productsPage.getTITLE().isDisplayed(), "User was not logged in");
    }
}
