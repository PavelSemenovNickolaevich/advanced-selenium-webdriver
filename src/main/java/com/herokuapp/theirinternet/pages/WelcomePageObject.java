package com.herokuapp.theirinternet.pages;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WelcomePageObject extends BasePageObject {

    private WebDriver driver;
    private Logger log;
    private String pageUrl = "http://the-internet.herokuapp.com/";
    private By formAuthenticationLocator = By.xpath("//a[@href='/login']");

    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

        /**Open WelcomePage with it's url*/
        public void openPage() {
            log.info ("Opening page: " + pageUrl);
            openUrl(pageUrl);
            log.info("Page opened!");
        }


    /** Open LoginPAge bu clicking on Form Authentication*/
    public LoginPage clickFormAuthentication() {
        log.info("Clicking Form Authentication link on welcome page");
        click(formAuthenticationLocator);
        return new LoginPage(driver, log);
    }


}
