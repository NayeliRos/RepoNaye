Feature: Actualizar usuario

Background:
  * url baseUrl
  * configure headers = { 'Content-Type': 'application/json' }

Scenario: Actualizar datos de usuario
  * def userId = '0uxuPY0cbmQhpEz1'
  # Obtener datos actuales del usuario
  Given path 'usuarios', userId
  When method get
  Then status 200
  * def datosActuales = response
  * def random = Math.floor(Math.random() * 1000000) + '' //genera el valor random
  * def nuevoEmail = 'useractualizado' + random + '@example.com' //concatena para armar el mail
  * print 'Nuevo email generado:', nuevoEmail

  * def datosActualizados =
    """
    {
      "nome": "#(datosActuales.nome)",
      "email": "#(nuevoEmail)",
      "password": "#(datosActuales.password)",
      "administrador": "#(datosActuales.administrador)"
    }
    """

  Given path 'usuarios', userId
  And request datosActualizados
  When method put
  Then status 200
  And match response.message == 'Registro alterado com sucesso'

Scenario Outline: No permitir email duplicado
  * def datosDuplicados =
    """
    {
      "nome": "Otro Usuario",
      "email": "prueba@example.com",
      "password": "abcdef",
      "administrador": "false"
    }
    """
  Given path 'usuarios', '<idUsuario>'
  And request datosDuplicados
  When method put
  Then status 400
  And match response.message contains 'email já está sendo usado'

Examples:
  | idUsuario          |
  | 1234567890abcdef   |