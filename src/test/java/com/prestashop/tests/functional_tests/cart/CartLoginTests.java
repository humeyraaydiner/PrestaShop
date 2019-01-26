package com.prestashop.tests.functional_tests.cart;

import com.prestashop.pages.*;
import com.prestashop.utilities.BrowserUtils;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class CartLoginTests extends TestBase {
    HomePage homePage;
    ProductPage productPage;
    CommonPage commonPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setupPages() {
        homePage = new HomePage();
        commonPage = new CommonPage();
        productPage = new ProductPage();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown() {
        homePage = null;
        commonPage = null;
        loginPage = null;
        productPage = null;
    }

    /**
     * Cart LoginTest
     * 1.Open browser
     * 2.Go to http://automationpractice.com/index.php
     * 3.Add any product in the homepage to the cart
     * 4.Hover over the cart icon
     * 5.Verify that cart contains the product
     * 6.Login as any valid user
     * 7.Hover over the cart icon
     * 8.Verify that cart information is same as step 5
     */

    @Test
    public void cartLogin() {
        driver.get(ConfigurationReader.getProperty("url"));

        //Add any product in the homepage to the cart
        String homePageProductName = homePage.getProduct("Printed Summer Dress").getText();
        action.moveToElement(homePage.getProduct("Printed Summer Dress")).perform();
        homePage.getAddToCartIdx(5).click();

        //Verify that cart contains the product
        productPage.closeIcon.click();

        //Hover over the cart icon
        action.moveToElement(commonPage.cartIcon).perform();

        //Verify that cart contains the product
        String cartProductName = commonPage.shoppingCartProductName.getText().replace(".", "");
        assertTrue(homePageProductName.contains(cartProductName));

        //Login as any valid user
        commonPage.signInButton.click();
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));

        //Hover over the cart icon
        action.moveToElement(commonPage.cartIcon).perform();

        //Verify that cart information is same as step 5
        assertTrue(homePageProductName.contains(cartProductName));
    }

}
