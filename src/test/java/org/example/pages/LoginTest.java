package org.example.pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void userShouldLoginWithValidCredentials(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        driver.findElement(By.cssSelector(".title"));
        assertTrue(productsPage.getTITLE().isDisplayed(), "User was not logged in");

    }

    @Test
    public void passwordShouldBeRequiredForLogin(){
        loginPage.open();
        loginPage.login("standard_user","");
        assertEquals(loginPage.getError(),"Epic sadface: Password is required","The error is incorrect");


    }
}
