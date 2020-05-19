package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theirinternet.base.BaseTest;
import com.herokuapp.theirinternet.base.TestUtilities;
import com.herokuapp.theirinternet.pages.LoginPage;
import com.herokuapp.theirinternet.pages.SecureAreaPage;
import com.herokuapp.theirinternet.pages.WelcomePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.core.Logger;

public class PositiveLogInTests extends TestUtilities {

    @Test
    public void logInTest() {
        log.info("Starting logIn test");

//		// Create driver
//		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();


        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthentication();

        // execute login
        SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword");

        // verifications
        // new url
        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

        // log out button is visible
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisisble(),
                "logOutButton is not visible.");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessfulMessage();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

    }
}
