package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.BaseTest;
import model.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoginSteps {
    private BaseTest baseTest = new BaseTest();
    private LoginPage loginPage;

    @Given("^Open link (.*?)$")
    public void userOpensLink(String url) {
        baseTest.webDriver.get(url);
        loginPage = new LoginPage(baseTest.webDriver);
    }

    @When("^User inputs login (.*?)$")
    public void userInputsLogin(String login){
        loginPage.setInputUserId(login);
    }

    @When("^User inputs password (.*?)$")
    public void userInputsPassword(String login){
        loginPage.setInputUserPassword(login);
    }

    @When("^User clicks button Login$")
    public void userClicksButtonLogin(){
        loginPage.clickButtonLogin();
    }

    @Then("Page is opened (.*?)$")
    public void pageWasOpened(String url){
        WebDriverWait w = new WebDriverWait(loginPage.webDriver, 30);
        w.until(ExpectedConditions.urlToBe(url));
        assertThat(loginPage.getCurrentUrl(), is(url));
    }

    @Then("Error message appeared (.*?)$")
    public void errorMessageAppeared(String errorMessage){
        loginPage.waitErrorMessageAppeared();
        assertThat(loginPage.getErrorMessage(), is(errorMessage));
    }
}