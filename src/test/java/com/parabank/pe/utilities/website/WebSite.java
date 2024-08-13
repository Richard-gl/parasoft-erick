package com.parabank.pe.utilities.website;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class WebSite {

    @Steps(shared = true)
    PageObject financialo;

    @Step("Navegar al sitio web")
    public void navigateTo(String url){
        financialo.setDefaultBaseUrl(url);
        financialo.open();
        maximizeWindow();

    }

    private void maximizeWindow() {
        WebDriver driver = financialo.getDriver();
        driver.manage().window().maximize();

    }

}
