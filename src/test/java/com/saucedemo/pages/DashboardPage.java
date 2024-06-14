package com.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{
    @FindBy(xpath = "//span[text()='Products']")
    public WebElement title;
    @FindBy(xpath = "//select")
    public WebElement sortDropDown;

    @FindBy (xpath = "//div[@class='pricebar']/button")
    public List<WebElement> addToCartBtns;

    @FindBy (xpath = "//div[@class='pricebar']")
    public List<WebElement> prices;
    @FindBy (css = ".shopping_cart_link")
    public WebElement basketBtn;
    public void addProducts (String cheapest, String costLiest) {
        Assert.assertTrue(prices.get(prices.size()-1).getText().contains(cheapest));
        addToCartBtns.get(addToCartBtns.size()-1).click();
        Assert.assertTrue(prices.get(1).getText().contains(costLiest));
        addToCartBtns.get(1).click();
    }
}
