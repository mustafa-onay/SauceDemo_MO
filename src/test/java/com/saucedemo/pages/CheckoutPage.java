package com.saucedemo.pages;

import com.saucedemo.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
    @FindBy(id = "first-name")
    public WebElement firstNameInput;
    @FindBy(id = "last-name")
    public WebElement lastNameInput;
    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;
    @FindBy(id = "continue")
    public WebElement continueBtn;
    @FindBy(css = ".summary_total_label")
    public WebElement summaryTotalInfo;
    @FindBy (id = "finish")
    public WebElement finishBtn;
    @FindBy(xpath = "//h2")
    public WebElement confirmationInfo;

    public void fillCheckoutForm (String firstname, String lastname, String postalCode){
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        postalCodeInput.sendKeys(postalCode);
        BrowserUtils.waitFor(2);
        continueBtn.click();

    }
}
