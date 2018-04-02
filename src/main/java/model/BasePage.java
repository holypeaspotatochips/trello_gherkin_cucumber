package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver webDriver;

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public boolean waitForObject(By locator){
        webDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        boolean result = webDriver.findElement(locator).isDisplayed();
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        return result;
    }
}
