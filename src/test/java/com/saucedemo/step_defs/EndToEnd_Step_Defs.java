package com.saucedemo.step_defs;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.DashboardPage;
import com.saucedemo.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class EndToEnd_Step_Defs {
    DashboardPage dashboardPage = new DashboardPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    @When("user sorts products {string}")
    public void user_sorts_products(String sortType) {
        new Select(dashboardPage.sortDropDown).selectByVisibleText(sortType);
    }
    @When("user adds the cheapest as {string} and the second costliest as {string} product")
    public void user_adds_the_cheapest_as_and_the_second_costliest_as_product(String cheapest, String costLiest) {
        dashboardPage.addProducts(cheapest,costLiest);
        BrowserUtils.sleep(2);
    }
    @When("user opens basket")
    public void user_opens_basket() {
        dashboardPage.basketBtn.click();
    }
    @When("user clicks on checkout")
    public void user_clicks_on_checkout() {
        cartPage.checkoutBtn.click();
    }
    @When("user enters details as {string} and {string} and {string}")
    public void user_enters_details_as_and_and(String firstname, String lastname, String postalCode) {
        checkoutPage.fillCheckoutForm(firstname,lastname,postalCode);
    }
    @Then("user verifies that the price is {string}")
    public void user_verifies_that_the_price_is(String expectedTotalInfo) {
        Assert.assertEquals(expectedTotalInfo,checkoutPage.summaryTotalInfo.getText());
    }
    @Then("user clicks on finish button")
    public void user_clicks_on_finish_button() {
        checkoutPage.finishBtn.click();
    }
    @Then("user should be able to see confirmation message as {string}")
    public void user_should_be_able_to_see_confirmation_message_as(String expectedMessage) {
        Assert.assertEquals(expectedMessage,checkoutPage.confirmationInfo.getText());
    }
}
