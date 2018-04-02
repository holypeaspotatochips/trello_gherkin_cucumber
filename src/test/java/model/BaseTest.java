package model;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest extends BasePage {
    
    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @After
    public void closeBrowser(){
        webDriver.quit();
    }
}