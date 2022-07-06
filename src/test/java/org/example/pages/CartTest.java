package org.example.pages;

import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void checkAddedProductToCart(){
        loginPage.open();
        loginPage.loginAsValidUser();
        cartPage.open();
    }
}
