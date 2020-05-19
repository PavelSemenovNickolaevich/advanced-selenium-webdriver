package com.herokuapp.theirinternet.pages;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {
    private WebDriver driver;
    private Logger log;
    private String pageUrl  = "http://the-internet.herokuapp.com/secure";
    private By logOutButton = By.xpath("//a[@class='button secondary radius']");
    private By successfulMessage = By.xpath("//div[@class='flash success']");



    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

//Get URL variable from PageObject
    public String getPageUrl() {
        return pageUrl;
    }

    //Verification is logOutButton is visible on the page
    public boolean isLogOutButtonVisisble() {
        return find(logOutButton).isDisplayed();
    }
//return text from success message
    public String getSuccessfulMessage() {
        return find(successfulMessage).getText();

    }
}
