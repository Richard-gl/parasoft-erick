package com.parabank.pe.definitions;

import com.github.javafaker.Faker;

import com.parabank.pe.steps.register.RegisterStep;
import com.parabank.pe.steps.validation.ValidationStep;
import com.parabank.pe.utilities.website.WebSite;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;

public class RegisterDef {

    @Steps(shared = true)
    WebSite url;

    @Steps(shared = true)
    RegisterStep register;

    @Steps(shared = true)
    ValidationStep validation;

    Faker faker = new Faker();

    private Map<String, String> generatedData = new HashMap<>();



    @Given("que el usuario está en la página principal de ParaBank {string}")
    public void userNavigateTo(String url_parabank){
       url.navigateTo(url_parabank);
    }

    @When("el usuario navega a la página de registro")
    public void el_usuario_navega_a_la_pagina_de_registro(){
        register.Step_clickRegisterLink();
    }

    @And("completa el formulario de registro con la siguiente información aleatoria")
    public void completa_el_formulario_de_registro_random_info(){

        generatedData.put("firstName", faker.name().firstName());
        generatedData.put("lastName", faker.name().lastName());
        generatedData.put("address", faker.address().streetAddress());
        generatedData.put("city", faker.address().city());
        generatedData.put("state", faker.address().state());
        generatedData.put("zipCode", faker.address().zipCode());
        generatedData.put("phone", faker.phoneNumber().cellPhone());
        generatedData.put("ssn", faker.idNumber().ssnValid());
        generatedData.put("username", faker.name().username());
        generatedData.put("password", faker.internet().password(8, 15));

        // Llenar el formulario con los datos generados
        register.Step_fillRegistrationForm(generatedData.get("firstName"), generatedData.get("lastName"), generatedData.get("address"),generatedData.get("city")
        , generatedData.get("state"), generatedData.get("zipCode"), generatedData.get("phone"), generatedData.get("ssn"), generatedData.get("username"), generatedData.get("password"));

    }

    @And("envía el formulario de registro")
    public void envia_El_Formulario_De_Registro() {
        register.Step_submitRegistrationForm();
    }

    @Then("debería ver el mensaje de éxito {string}")
    public void deberia_ver_mensaje_exito(String expectedMessage){
        String actualMessage = validation.Step_getSuccessMessage();

        System.out.println(actualMessage);
        System.out.println(expectedMessage);

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("el usuario cierra sesión")
    public void usuario_cierra_sesion(){
        register.Step_Logout();
    }

    @And("el usuario se loguea con las credenciales de la cuenta recién creada")
    public void usuario_ingresa_crendenciales(){
        register.Step_Login(generatedData.get("username"), generatedData.get("password"));

    }

    @Then("debería ver el mensaje de bienvenida")
    public void ver_mensaje_bienvenida(){
        Assert.assertTrue(validation.Step_isUserAuthenticated());
    }




}
