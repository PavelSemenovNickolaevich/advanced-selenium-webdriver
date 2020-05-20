package com.herokuapp.theinternet.dropdowntests;

import com.herokuapp.theirinternet.base.TestUtilities;
import com.herokuapp.theirinternet.pages.DropdownPage;
import com.herokuapp.theirinternet.pages.WelcomePageObject;
import org.junit.Assert;
import org.junit.Test;

public class DropdownTest extends TestUtilities {

    @Test
    public void optionTwoTest() {
        log.info("Starting optionTwoTest");

        //openmainpage
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        //ckick dropdown link
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        //Select Option 2
        dropdownPage.selectOption(2);

        //verify option 2 is selected
        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOption.equals("Option 2"),
                "Option 2 is not selected. Istead selected - " + selectedOption);
    }
}
