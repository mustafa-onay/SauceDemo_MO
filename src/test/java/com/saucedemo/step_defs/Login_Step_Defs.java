package com.saucedemo.step_defs;

import com.saucedemo.pages.DashboardPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.ConfigReader;
import com.saucedemo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_Step_Defs {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.get("url"));
    }
    @When("user enters {string} username {string} password and clicks on the login button")
    public void user_enters_username_password_and_clicks_on_the_login_button(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("verify that user can see {string} on the Dashboard")
    public void verify_that_user_can_see_on_the_dashboard(String expectedTitle) {
        Assert.assertEquals(expectedTitle,dashboardPage.title.getText());
    }
}
