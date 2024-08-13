package com.parabank.pe.steps.validation;

import com.parabank.pe.pages.validation.ValidationPage;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ValidationStep extends ScenarioSteps {

    ValidationPage validation;

    @Step("Usuario registrado exitosamente")
    public String Step_getSuccessMessage(){
        return validation.getSuccessMessage();
    }

    @Step("Usuario autenticado exitosamente")
    public boolean Step_isUserAuthenticated(){
        return validation.isUserAuthenticated();
    }

}
