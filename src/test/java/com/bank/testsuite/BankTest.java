package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
 baseUrl :http://www.way2automation.com/angularjs-protractor/banking/#/login
 Project name: xyz-bank
 Group-Id : com.bank
        main package.
        create all packages and class that you created in previous project
        In Pages package
        1.HomePage
        2.CustomerLoginPage
        3.BankManagerLoginPage
        4.AddCustomerPage
        5.OpenAccountPage
        6.CustomersPage
        7.AccountPage - store Transaction, deposit and withdraw.

        test package.
        create all packages and class that you created in previous project

 1.BankTest
  Inside this create testmethods
*/

public class BankTest extends TestBase {

    // Test data that is being used for the testing purpose
    String firstName = "James";
    String lastName  = "Bond";
    String customer  = firstName + " " + lastName;
    String postcode  = "HA6 1NW";
    String currency  = "Pound";
    String depositAmount = "100";
    String withdrawlAmount = "50";

    //Objects created for the various Pages for use in the tests
    HomePage homePage = new HomePage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    AddCustomerPage addCustomerPage = new AddCustomerPage();
    OpenAccountPage openAccountPage = new OpenAccountPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();
    CustomerPage customerPage = new CustomerPage();
    AccountPage accountPage = new AccountPage();
/*
   1.bankManagerShouldAddCustomerSuccessfully.
    click On "Bank Manager Login" Tab
    click On "Add Customer" Tab
    enter FirstName
    enter LastName
    enter PostCode
    click On "Add Customer" Button
    popup display
    verify message "Customer added successfully"
    click on "ok" button on popup.
*/

    @Test(priority = 0)
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.enterNewUserFirstName(firstName);
        addCustomerPage.enterNewUserLastName(lastName);
        addCustomerPage.enterNewUserPostcode(postcode);
        addCustomerPage.clickOnAddCustomerBtn();
        addCustomerPage.popUpDisplayMessage();
        Alert alert = driver.switchTo().alert();
        String expectedText = "Customer added successfully";
        String actualText = alert.getText();
        Assert.assertTrue(actualText.contains("Customer added successfully"), expectedText);
        alert.accept();
        bankManagerLoginPage.clickOnHomepageBtn();
    }

  /* 2. bankManagerShouldOpenAccountSuccessfully.
    click On "Bank Manager Login" Tab
    click On "Open Account" Tab
    Search customer that created in first test
    Select currency "Pound"
    click on "process" button
    popup displayed
    verify message "Account created successfully"
    click on "ok" button on popup.
*/

    @Test(priority = 1)
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnOpenAccountTab();
        openAccountPage.selectCustomerNameFromDropDown(customer);
        openAccountPage.selectCurrencyFromDropDown(currency);
        openAccountPage.clickOnProcessButton();
        openAccountPage.popUpDisplayMessage();
        Alert alert = driver.switchTo().alert();
        String expectedText = "Account created successfully";
        String actualText = alert.getText();
        Assert.assertTrue(actualText.contains("Account created successfully"), expectedText);
        alert.accept();
        bankManagerLoginPage.clickOnHomepageBtn();
    }

    /*
      3. customerShouldLoginAndLogoutSuceessfully.
    click on "Customer Login" Tab
    search customer that you created.
    click on "Login" Button
    verify "Logout" Tab displayed.
    click on "Logout"
    verify "Your Name" text displayed.
*/
    @Test(priority = 2)
    public void customerShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.clickOnYourName();
        customerLoginPage.selectYourNameOnCustomerPage(customer);
        customerLoginPage.clickOnCustomerLoginButton();

        customerPage.verifyCustomerLoutOutTabIsDisplayed();
        String expectedTab = "Logout";
        String actualTab = customerPage.getCustomerLoutOutText();
        Assert.assertEquals(expectedTab, actualTab);
        customerPage.clickOnCustomerLogOutButton();
        customerLoginPage.verifyThatYourNameTextIsDisplayed();
        String expectedText = "Your Name :";
        String actualText = customerLoginPage.getYourNameTextMessage();
        Assert.assertEquals(expectedText, actualText);
        customerLoginPage.clickOnHomepageBtn();
    }

    /*
        4. customerShouldDepositMoneySuccessfully.
        click on "Customer Login" Tab
        search customer that you created.
        click on "Login" Button
        click on "Deposit" Tab
        Enter amount 100
        click on "Deposit" Button
        verify message "Deposit Successful"
    */
    @Test(priority = 3)
    public void customerShouldDepositMoneySuccessfully() {

        homePage.clickOnCustomerLoginTab();
        customerLoginPage.clickOnYourName();
        customerLoginPage.selectYourNameOnCustomerPage(customer);
        customerLoginPage.clickOnCustomerLoginButton();
        accountPage.clickOnDepositTab();
        accountPage.enterDepositAmount(depositAmount);
        accountPage.clickOnDepositButton();
        accountPage.verifyThatDepositSuccessfulTextisDisplayed();
        accountPage.getDepositSuccessfulText();
        String expectedText = "Deposit Successful";
        String actualText = accountPage.getDepositSuccessfulText();
        Assert.assertEquals(expectedText, actualText);
        accountPage.clickOnHomepageBtn();

    }

/*          5. customerShouldWithdrawMoneySuccessfully
    click on "Customer Login" Tab
    search customer that you created.
    click on "Login" Button
    click on "Withdrawl" Tab
    Enter amount 50
    click on "Deposit" Button
    verify message "Transaction Successful"
*/

    @Test(priority = 4)
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.clickOnYourName();
        customerLoginPage.selectYourNameOnCustomerPage(customer);
        customerLoginPage.clickOnCustomerLoginButton();
        accountPage.clickOnWithdrawlTab();
        accountPage.enterWithdrawlAmount(withdrawlAmount);
        accountPage.clickOnWithdrawlButton();
        accountPage.verifyThatTransactionSuccessfulTextisDisplayed();
        String expectedText = "Transaction successful";
        String actualText = accountPage.getTransactionSuccessfulText();
        Assert.assertEquals(expectedText, actualText);
    }
}
