package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.BaseTest;
import model.BoardPage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardSteps {
    private BaseTest baseTest = new BaseTest();
    private BoardPage boardPage = new BoardPage(baseTest.webDriver);

    @When("^User clicks board name (.*?)$")
    public void clicksBoardName(String boardName){
        boardPage.userClicksBoardName(boardName);
        assertThat(boardPage.isOverlayVisible(), is(true));
    }

    @When("^User clicks menu link$")
    public void clicksMenuLink(){
        boardPage.userClicksMenuLink();
    }

    @When("^User fills comment (.*?)$")
    public void userFillsComment(String comment){
        boardPage.userClicksBoard();
        boardPage.fillComment(comment);
    }

    @When("^User saves comment$")
    public void userSavesComment(){
        boardPage.savesComment();
    }

    @Then("^User can see comment$")
    public void userCanSeeComment(){
        boardPage.commentIsPresent();
    }
}