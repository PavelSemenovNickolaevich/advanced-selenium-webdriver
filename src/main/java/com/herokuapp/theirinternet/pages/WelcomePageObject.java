package com.herokuapp.theirinternet.pages;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WelcomePageObject {

    private WebDriver driver;
    private Logger log;
    private String pageUrl = "http://the-internet.herokuapp.com/";
    private By formAuthenticationLocator = By.xpath("//a[@href='/login']");

    public WelcomePageObject(WebDriver driver, Logger log) {
        this.log = log;
        this.driver = driver;
    }

        /**Open WelcomePage with it's url*/
        public void openPage() {
            log.info ("Opening page: " + pageUrl);
            driver.get(pageUrl);
            log.info("Page opened!");
        }

    /** Open LoginPAge bu clicking on Form Authentication*/
    public LoginPage clickFormAuthentication() {
        log.info("Clicking Form Authentication link on welcome page");
        driver.findElement(formAuthenticationLocator).click();
        return new LoginPage(driver, log);
    }


}
