# language: en

@registro_login
Feature: Registro e inicio de sesión en ParaBank
  Como un nuevo usuario de ParaBank
  Quiero poder registrarme en el sitio
  Y luego iniciar sesión con mi cuenta recién creada
  Para acceder a los servicios bancarios en línea

  Background:
    Given que el usuario está en la página principal de ParaBank "https://parabank.parasoft.com/parabank/index.htm"

  @registro_login_exitoso
  Scenario: Registro exitoso de un nuevo usuario
    When el usuario navega a la página de registro
    And completa el formulario de registro con la siguiente información aleatoria
    And envía el formulario de registro
    Then debería ver el mensaje de éxito "Your account was created successfully. You are now logged in."

    When el usuario cierra sesión
    * el usuario se loguea con las credenciales de la cuenta recién creada
    Then debería ver el mensaje de bienvenida
