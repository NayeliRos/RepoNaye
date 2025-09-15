Feature: Listar usuarios

Background:
  * url baseUrl
  * configure headers = { 'Content-Type': 'application/json' }

Scenario: Obtener lista de usuarios
  Given path 'usuarios'
  When method get
  Then status 200
  And match response == '#object'
  * print 'Respuesta recibida:', response