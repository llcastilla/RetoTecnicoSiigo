Feature: Consultar Usuario por ID

  Scenario: Generar consulta de usuarios por id
    Given que el servicio de consulta de usuarios está disponible
    When se realiza una solicitud GET al endpoint de usuarios por id
    Then el servicio responde con el código de estado OK