package com.parabank.pe.pages.validation;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ValidationPage extends PageObject {



    @FindBy(xpath = "//*[@id='rightPanel']/p")
    protected WebElementFacade successMessage;

    @FindBy(xpath = "//*[@id='leftPanel']/p/b")
    protected WebElementFacade welcomeMessage;

    public String getSuccessMessage() {

        return successMessage.waitUntilVisible().getText();
    }

    public boolean isUserAuthenticated() {
        return welcomeMessage.waitUntilVisible().isDisplayed();
    }


}
