package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class AddCustomerPage extends Utility {

    By firstNameField = By.xpath("//input[@placeholder='First Name']");
    By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    By postcodeField = By.xpath("//input[@placeholder='Post Code']");
    By addCustomerBtn = By.xpath("//button[@class='btn btn-default']");
    By homePageBtn = By.xpath("//button[@class='btn home']");

    public void clickOnHomepageBtn () {
        clickOnElement(homePageBtn);
    }


    public void enterNewUserFirstName (String firstName){
        sendTextToElement(firstNameField, firstName);
    }

    public void enterNewUserLastName (String lastName){
        sendTextToElement(lastNameField,lastName);
    }
    public void enterNewUserPostcode (String postcode){
        sendTextToElement(postcodeField,postcode);
    }
    public void clickOnAddCustomerBtn (){
        clickOnElement(addCustomerBtn);
    }
    public void popUpDisplayMessage (){
       alertPopUp();
        }




}
