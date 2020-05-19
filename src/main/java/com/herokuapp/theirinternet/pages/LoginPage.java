package com.herokuapp.theirinternet.pages;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

    private WebDriver driver;
    private Logger log;
    private By buttonLogin = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
    private By usernameLocator = By.xpath("//input[@id='username']");
    private By passwordLocator = By.xpath("//input[@id='password']");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
//LogIn
    public SecureAreaPage login(String username, String password) {
        log.info("Executing Login with username [" + username + "] and password [" + password + "]");
//        driver.findElement(usernameLocator).sendKeys(username);
//        driver.findElement(passwordLocator).sendKeys(password);
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(buttonLogin);
        return new SecureAreaPage(driver, log);
    }




}
