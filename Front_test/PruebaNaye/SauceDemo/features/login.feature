Feature: Login en SauceDemo

  Scenario: Login con usuario válido 
    Given que estoy en la página de login
    When inicio sesión con el usuario "standard_user" y contraseña "secret_sauce"
    Then debo ver el inventario de productos

  Scenario: Login con usuario bloqueado
    Given que estoy en la página de login
    When inicio sesión con el usuario "locked_out_user" y contraseña "secret_sauce"
    Then debería ver el mensaje de error "Epic sadface: Sorry, this user has been locked out."
