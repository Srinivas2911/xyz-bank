package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By homeButton = By.xpath("//button[@class='btn home']");
    //Customer login btn
    By customerLoginTab = By.xpath("//button[contains(text(),'Customer Login')]");
    // Bank Manager login Btn
    By bankManagerLoginTab = By.xpath("//button[contains(text(),'Bank Manager Login')]");

    public void clickOnBankManagerLoginTab (){
        clickOnElement(bankManagerLoginTab);
    }

    public void clickOnCustomerLoginTab (){
        clickOnElement(customerLoginTab);
    }

}
