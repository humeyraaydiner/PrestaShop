package com.prestashop.pages;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//h5//a[@title='Printed Dress'])[1]")
    public WebElement homePageProductName;

    @FindBy(xpath = "(//span[@class='price product-price'])[6]")
    public WebElement homePageProductPrice;

    @FindBy(xpath = "(//h5//a[@title='Faded Short Sleeve T-shirts'])[1]")
    public WebElement notSaleProduct;

    @FindBy(xpath = "(//a[@title='Printed Summer Dress'])[2]")
    public WebElement saleProduct;



}

