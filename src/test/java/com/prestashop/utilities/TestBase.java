package com.prestashop.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions action;
    protected Faker faker = new Faker();

    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action = new Actions(driver);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
        softAssert.assertAll();
    }
}
