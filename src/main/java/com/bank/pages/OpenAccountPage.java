package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class OpenAccountPage extends Utility {

    By selectCustName = By.xpath("//select[@name='userSelect']");
    By selectCurrency = By.xpath("//select[@name='currency']");
    By processBtn = By.xpath("//button[contains(text(),'Process')]");

    By homePageBtn = By.xpath("//button[@class='btn home']");

    public void clickOnHomepageBtn () {
        clickOnElement(homePageBtn);
    }

    public void selectCustomerNameFromDropDown (String customer){
        selectByVisibleTextFromDropDown(selectCustName, customer);
    }
    public void selectCurrencyFromDropDown(String currency){
        selectByVisibleTextFromDropDown(selectCurrency, currency);
    }
    public void clickOnProcessButton(){
        clickOnElement(processBtn);
    }
    public void popUpDisplayMessage (){
        alertPopUp();
    }

}
