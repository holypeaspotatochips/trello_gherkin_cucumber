package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private By inputUserId = By.xpath("//*[@id='user']");
    private By inputUserPassword = By.xpath("//*[@id='password']");
    private By buttonLogin = By.xpath("//*[@id='login']");
    private By buttonLoginViaGoogle = By.xpath("//*[@id='google-link']");

    private By loginError = By.xpath("//*[@id='error']/p");

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void setInputUserId(String userId){
        webDriver.findElement(inputUserId).sendKeys(userId);
    }

    public void setInputUserPassword(String userPassword){
        webDriver.findElement(inputUserPassword).sendKeys(userPassword);
    }

    public void clickButtonLogin(){
        webDriver.findElement(buttonLogin).click();
    }

    public void waitErrorMessageAppeared(){
        WebDriverWait w = new WebDriverWait(webDriver, 30);
        w.until(ExpectedConditions.visibilityOf(webDriver.findElement(loginError)));
    }

    public String getErrorMessage(){
        return webDriver.findElement(loginError).getText();
    }
}