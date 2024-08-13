package com.parabank.pe.pages.validation;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidationPage extends PageObject {

    private WebDriverWait wait;


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
