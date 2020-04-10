package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage  extends Utility {

    By selectUser = By.xpath("//select[@name='userSelect']");
    By loginCustomerBtn = By.xpath("//button[@class='btn btn-default']");
    By yourNameText = By.xpath("//label[contains(text(),'Your Name :')]");
    By homePageBtn = By.xpath("//button[@class='btn home']");

    public void clickOnHomepageBtn () {
        clickOnElement(homePageBtn);
    }
        public void clickOnYourName(){
        clickOnElement(selectUser);
    }

    public void selectYourNameOnCustomerPage(String customer){
        selectByVisibleTextFromDropDown(selectUser, customer);
    }

    public void verifyThatYourNameTextIsDisplayed (){
        verifyThatTextIsDisplayed(yourNameText, "Your Name :");
    }


    public String getYourNameTextMessage (){
        return getTextFromElement(yourNameText);
    }

    public void clickOnCustomerLoginButton(){
        waitUntilElementToBeClickable(loginCustomerBtn, 20);
        clickOnElement(loginCustomerBtn);
    }

}

