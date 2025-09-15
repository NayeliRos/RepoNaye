Feature: compra en SauceDemo
    
  Scenario Outline: Login con usuario válido y completar compra
    Given que estoy en la página de login
    When inicio sesión con el usuario "standard_user" y contraseña "secret_sauce"
    Then debo ver el inventario de productos
    When agrego un producto al carrito
    Then ingreso al carro de compra
    When completo el checkout con los datos de nombre "<nombre>", apellido "<apellido>" y zip "<zip>"
    Then debería ver el mensaje "Thank you for your order!"

  Examples:
  |nombre |apellido   |zip    |
  |Luis   |Rodriguez  |11111  |


  Scenario: Login con usuario válido y revisa su carrito de compra
    Given que estoy en la página de login
    When inicio sesión con el usuario "standard_user" y contraseña "secret_sauce"
    Then debo ver el inventario de productos
    When agrego el producto "Sauce Labs Fleece Jacket" al carrito
    Then ingreso al carro de compra


Scenario Outline: Login con usuario válido y completar compra sin selecionar producto
    Given que estoy en la página de login
    When inicio sesión con el usuario "standard_user" y contraseña "secret_sauce"
    Then debo ver el inventario de productos
    Then ingreso al carro de compra
    When completo el checkout con los datos de nombre "<nombre>", apellido "<apellido>" y zip "<zip>"
    Then debería ver el mensaje "Thank you for your order!"

  Examples:
  |nombre |apellido   |zip    |
  |Luis   |Rodriguez  |11111  |
