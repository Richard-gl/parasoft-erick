package com.parabank.pe.steps.register;

import com.parabank.pe.pages.register.RegisterPage;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class RegisterStep extends ScenarioSteps {

   RegisterPage register;

   @Step("Click en el link de Registrar")
    public void Step_clickRegisterLink(){
       register.clickRegisterLink();
   }

   @Step("Llenar la información del formulario de registro")
    public void Step_fillRegistrationForm(String firstName, String lastName, String address, String city,
                                          String state, String zipCode, String phone, String ssn,
                                          String username, String password){

       register.fillRegistrationForm(firstName,lastName,address,city, state,zipCode, phone, ssn, username, password);
   }

   @Step("Enviar formulario de registro")
    public void Step_submitRegistrationForm(){
       register.submitRegistrationForm();
   }

   @Step("Cerrar Sesión de Usuario recien creado")
    public void Step_Logout(){
       register.Logout();
    }

    @Step("Iniciar Sesión con Usuario recien creado")
    public void Step_Login(String username, String password){
       register.login(username, password);
    }

}
