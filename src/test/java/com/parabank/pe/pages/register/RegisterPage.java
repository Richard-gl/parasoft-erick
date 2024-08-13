package com.parabank.pe.pages.register;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegisterPage extends PageObject {


    @FindBy(linkText = "Register")
    protected WebElementFacade registerlink;

    @FindBy(xpath = "//input[@id='customer.firstName']")
    protected WebElementFacade firstNameInput;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    protected WebElementFacade lastNameInput;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    protected WebElementFacade addressInput;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    protected WebElementFacade cityInput;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    protected WebElementFacade stateInput;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    protected WebElementFacade zipCodeInput;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    protected WebElementFacade phoneInput;

    @FindBy(xpath = "//input[@id='customer.ssn']")
    protected WebElementFacade ssnInput;

    @FindBy(xpath = "//input[@id='customer.username']")
    protected WebElementFacade usernameInput;

    @FindBy(xpath = "//input[@id='customer.password']")
    protected WebElementFacade passwordInput;

    @FindBy(xpath = "//input[@id='repeatedPassword']")
    protected WebElementFacade repeatedPasswordInput;

    @FindBy(xpath = "//input[@type='submit' and @class='button' and @value='Register']")
    protected WebElementFacade registerButton;


    @FindBy(linkText = "Log Out")
    protected WebElementFacade logoutButton;


    @FindBy(xpath = "//input[@name='username']")
    protected WebElementFacade loginUsernameInput;

    @FindBy(xpath = "//input[@name='password']")
    protected WebElementFacade loginPasswordInput;

    @FindBy(xpath = "//input[@type='submit' and @class='button' and @value='Log In']")
    protected WebElementFacade loginButton;

    public void clickRegisterLink(){
        registerlink.waitUntilVisible().click();
    }

    public void fillRegistrationForm(String firstName, String lastName, String address, String city,
                                     String state, String zipCode, String phone, String ssn,
                                     String username, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        stateInput.sendKeys(state);
        zipCodeInput.sendKeys(zipCode);
        phoneInput.sendKeys(phone);
        ssnInput.sendKeys(ssn);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        repeatedPasswordInput.sendKeys(password);
    }

    public void submitRegistrationForm() {
        registerButton.click();
    }

    public void Logout(){
        logoutButton.waitUntilVisible().click();
    }



    public void login(String username, String password) {
        loginUsernameInput.waitUntilVisible().sendKeys(username);
        loginPasswordInput.waitUntilVisible().sendKeys(password);
        loginButton.waitUntilVisible().click();
    }

}
