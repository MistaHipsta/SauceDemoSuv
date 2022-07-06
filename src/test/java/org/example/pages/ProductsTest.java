package org.example.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{

    @Test
    public void productsShouldBeAddedToCart(){
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.open();
        productsPage.addToCart("Sauce Labs Backpack");
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        String testPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        Assert.assertEquals(testPrice,"$29.99");
        String testName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(testName,"Sauce Labs Backpack");


    }


}
