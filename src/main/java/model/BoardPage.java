package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardPage extends BasePage {
    final By cardName = By.xpath("//span[contains(@class, 'name')]");
    final By menuLink = By.xpath("//*[@id='content']//span[contains(@class, 'menu')]");
    final By overlay = By.xpath("//*[@id='content']//*[@class = 'board-canvas']");
    final By boardDetails = By.xpath("//*[@id='board']//div[contains(@class, 'details')]");

    final By inputComment = By.xpath("//*[@id='classic']//textarea[@class = 'comment-box-input js-new-comment-input']");
    final By buttonSaveComment = By.xpath("//*[@id='classic']//input[@class = 'primary confirm mod-no-top-bottom-margin js-add-comment']");
    final By textareaComment = By.xpath("//*[@id='classic']//div[@class = 'current-comment js-friendly-links js-open-card']");

    public BoardPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void userClicksBoardName(String boardName){
        webDriver.findElements(cardName).stream()
                .filter(e -> e.getText().equals(boardName))
                .findFirst()
                .get()
                .click();
    }

    public void userClicksMenuLink(){
        webDriver.findElements(menuLink).stream()
        .filter(e -> e.isDisplayed())
        .findFirst()
        .get()
        .click();
    }

    public void userClicksBoard(){
        webDriver.findElement(boardDetails).click();
    }

    public boolean isOverlayVisible(){
        return waitForObject(overlay);
    }

    public void fillComment(String comment){
        webDriver.findElement(inputComment).sendKeys(comment);
    }

    public void savesComment(){
        webDriver.findElement(buttonSaveComment).click();
    }

    public void commentIsPresent(){
        webDriver.findElement(textareaComment).isDisplayed();
    }
}
