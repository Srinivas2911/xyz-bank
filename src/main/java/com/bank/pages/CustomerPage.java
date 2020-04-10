package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomerPage extends Utility {

    By customerLogoutBtn = By.xpath("//button[@class='btn logout']");

    By homePageBtn = By.xpath("//button[@class='btn home']");

    public void clickOnHomepageBtn () {
        clickOnElement(homePageBtn);
    }

    public String getCustomerLoutOutText (){
        return getTextFromElement(customerLogoutBtn);
    }

    public void verifyCustomerLoutOutTabIsDisplayed (){
        verifyThatElementIsDisplayed(customerLogoutBtn);
    }

    public void clickOnCustomerLogOutButton(){
        clickOnElement(customerLogoutBtn);
    }

}
