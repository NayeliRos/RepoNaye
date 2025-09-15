Feature: Registrar usuario

Background:
  * url baseUrl
  * configure headers = { 'Content-Type': 'application/json' }

Scenario: Registrar usuario válido
  * def usuarioFijo =
    """
    {
      "nome": "Usuario",
      "email": "abcd12@gmail.com",
      "password": "123456",
      "administrador": "true"
    }
    """
  Given path 'usuarios'
  And request usuarioFijo
  When method post
  Then status 201
  And match response.message == 'Cadastro realizado com sucesso'
  And match response._id == '#string'
  * def userId = response._id

  # Eliminar el usuario creado
  Given path 'usuarios', userId
  When method delete
  Then status 200
  And match response.message contains 'Registro excluído com sucesso'

Scenario: No permitir correo Repetido
  * def usuarioCorreoRepetido =
    """
    {
      "nome": "Correo repetido",
      "email": "beltrano@qa.com.br",
      "password": "teste",
      "administrador": "true"
    }
    """
  Given path 'usuarios'
  And request usuarioCorreoRepetido
  When method post
  Then status 400
  And match response.message == 'Este email já está sendo usado'
