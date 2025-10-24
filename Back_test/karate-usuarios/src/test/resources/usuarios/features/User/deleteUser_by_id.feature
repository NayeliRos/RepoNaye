Feature: Eliminar usuario

Background:

  * url baseUrl
  * configure headers = { 'Content-Type': 'application/json' }
  * def nuevoUsuario =
    """
    {
      "nome": "Usuario a eliminar",
      "email": "eliminar123@gmail.com",
      "password": "123456",
      "administrador": "true"
    }
    """

    Given path 'usuarios'
    And request nuevoUsuario
    When method post
    Then status 201
  * def userId = response._id

Scenario: Eliminar usuario creado
  Given path 'usuarios', userId
  When method delete
  Then status 200
  And match response.message contains 'Registro excluído com sucesso'