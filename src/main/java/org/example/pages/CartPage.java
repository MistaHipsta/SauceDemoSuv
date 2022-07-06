package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{

    private final By TITLECART = By.cssSelector(".title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL + "cart.html");
    }

    public WebElement getTITLE() {
        return driver.findElement(TITLECART);
    }
}
