package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class AccountPage extends Utility {

    By depositTab = By.xpath("//button[contains(text(),'Deposit')]");
    By amountDeposit = By.xpath("//input[@placeholder='amount']");
    By depositBtn = By.xpath("//button[@class='btn btn-default']");
    By depositSuccessText = By.xpath("//span[@class='error ng-binding']");

    By withdrawlTab = By.xpath("//button[contains(text(),'Withdrawl')]");
    By amountWithdrawl = By.xpath("//input[@placeholder='amount']");
    By withdrawlBtn = By.xpath("//button[@class='btn btn-default']");
    By transactionSuccessText = By.xpath("//span[@class='error ng-binding']");

    By homePageBtn = By.xpath("//button[@class='btn home']");

    public void clickOnHomepageBtn ()  {
        clickOnElement(homePageBtn);
    }


    public void clickOnDepositTab(){
        clickOnElement(depositTab);
    }

    public void enterDepositAmount(String depositAmount){
        clickOnElement(amountDeposit);
        sendTextToElement(amountDeposit, depositAmount);
    }

    public void clickOnDepositButton () {
        clickOnElement(depositBtn);
    }

    public String getDepositSuccessfulText (){
        return getTextFromElement(depositSuccessText);
    }

    public void verifyThatDepositSuccessfulTextisDisplayed(){
        verifyThatTextIsDisplayed(depositSuccessText, "Deposit Successful");
    }

public void clickOnWithdrawlTab (){
        clickOnElement(withdrawlTab);
}

public void enterWithdrawlAmount (String withdrawlAmount){
        clickOnElement(amountWithdrawl);
        sendTextToElement(amountWithdrawl, withdrawlAmount);
}

public void clickOnWithdrawlButton (){
        clickOnElement(withdrawlBtn);
}

    public void verifyThatTransactionSuccessfulTextisDisplayed() {
        verifyThatTextIsDisplayed(transactionSuccessText, "Transaction successful");
    }
    public String getTransactionSuccessfulText (){
        return getTextFromElement(transactionSuccessText);
    }

}

