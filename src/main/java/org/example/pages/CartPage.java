package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "cart.html");
    }

    public void deleteProductFromCart() {
        driver.findElement(By.xpath("//div[@class='item_pricebar']/button"));
    }

    public String productNameCheck() {
        String addedProduct = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        return addedProduct;
    }

    public void addProductToCartAsValid(String product) {
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.addToCart(product);
    }

    public void goToCheckout() {
        driver.findElement(By.xpath("//button[@id='checkout']"));
    }

    public void continueShopping(){
        driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
    }

    public String checkTitle(){
        String tittle = driver.findElement(By.xpath("//span[@class='title']")).getText();
        return tittle;
    }
}
