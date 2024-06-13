package com.saucedemo.step_defs;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Negative_Login_StepDefs {
    LoginPage loginPage = new LoginPage();

    @Then("verify that user should be able to see warning message as {string}")
    public void verify_that_user_should_be_able_to_see_warning_message_as(String expectedMessage) {
        Assert.assertEquals(expectedMessage,loginPage.getWarningMessage(expectedMessage));
    }
}
