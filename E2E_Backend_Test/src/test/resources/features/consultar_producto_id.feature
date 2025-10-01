Feature: Consultar producto por ID

  Scenario: Generar consulta de producto por id
    Given que el servicio de consulta de producto está disponible
    When se realiza una solicitud GET al endpoint de producto por id
    Then el servicio responde con el código de estado