package com.prestashop.utilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class BrowserUtils {

    public static boolean verifyTextMatches(String str1, String str2) {
        return str1.equals(str2);
    }

    public static boolean verifyTextContains(String str1, String str2) {
        return str1.contains(str2);
    }

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (Exception e ){
            System.out.println("Exception message: "+e.getMessage());
        }
    }

    public static void explicitWait(WebElement target){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(target));
    }

    public void switchWindow() {
        for(String winHandle : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(winHandle);
        }
    }

    public static void captureScreenShot(WebDriver driver, String name){ //name parameter is for when you get different screenshot you can name them differently.
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File("./ScreenShots/" + name+ ".png"));
        }
        catch (Exception e){
            System.out.println("Exception while taking Screen shot: " + e.getMessage());
        }
    }
}
