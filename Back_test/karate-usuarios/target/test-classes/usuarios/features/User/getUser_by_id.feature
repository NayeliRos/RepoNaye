Feature: Buscar usuario por ID

Background:
  * url baseUrl
  * configure headers = { 'Content-Type': 'application/json' }


Scenario: Buscar usuario existente
  Given path 'usuarios', '0uxuPY0cbmQhpEz1'
  When method get
  Then status 200
  And match response == { _id: '#string', nome: '#string', email: '#string', password: '#string', administrador: '#string' }

Scenario: Buscar usuario inexistente
  Given path 'usuarios', 'ZyXwVuTs87655555'
  When method get
  Then status 400
  And match response.message contains 'Usuário não encontrado'