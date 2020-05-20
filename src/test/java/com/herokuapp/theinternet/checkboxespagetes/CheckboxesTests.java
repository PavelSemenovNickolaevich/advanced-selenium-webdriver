package com.herokuapp.theinternet.checkboxespagetes;

import com.herokuapp.theirinternet.pages.CheckboxesPage;
import com.herokuapp.theirinternet.pages.WelcomePageObject;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.junit.Assert;
import org.junit.Test;
import com.herokuapp.theirinternet.base.TestUtilities;

public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTest() {
//        log.info("Starting selectingTwoCheckboxesTest");

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        //Ckick on Checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();


        //Select all Checkboxes
        checkboxesPage.selectAllCheckBoxes();

        //Verify all checkboxes are checked
        Assert.assertEquals(checkboxesPage.areAllCheckBoxesChecked(), "Not all checkboxes are checked");


    }

}
