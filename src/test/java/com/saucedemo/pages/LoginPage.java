package com.saucedemo.pages;

import com.saucedemo.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy (id = "user-name")
    public WebElement usernameInput;
    @FindBy (id = "password")
    public WebElement passwordInput;
    @FindBy(id = "login-button")
    public WebElement loginBtn;
    @FindBy(xpath = "//h3")
    public WebElement generalAlertMessage;
    public void login (String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public String getWarningMessage (String message) {  // sehr wichtige methode

        String actualMessage = message;
        BrowserUtils.sleep(2);
        if (message.contains("Epic sadfac: Password is required")) {
            actualMessage = passwordInput.getAttribute("Epic sadface: Password is required");
        }
        if (message.contains("Epic saface: Username is required")){
            actualMessage = usernameInput.getAttribute("Epic sadface: Username is required");
        }else if (message.contains("Epic sadface: Username and password")) {
            actualMessage = generalAlertMessage.getText();
        }
        System.out.println("actualMessage = " + actualMessage);
        return actualMessage;
    }
}
