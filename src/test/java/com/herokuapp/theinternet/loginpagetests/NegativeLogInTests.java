package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theirinternet.base.BaseTest;
import com.herokuapp.theirinternet.base.TestUtilities;
import com.herokuapp.theirinternet.pages.LoginPage;
import com.herokuapp.theirinternet.pages.SecureAreaPage;
import com.herokuapp.theirinternet.pages.WelcomePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLogInTests extends TestUtilities {

	WebDriver driver;


	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthentication();

		//Execute logIN
		loginPage.negativeLogin(username, password);

		//Wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessage();

		// Verification
		Assert.assertTrue(message.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + message);
	}

}
