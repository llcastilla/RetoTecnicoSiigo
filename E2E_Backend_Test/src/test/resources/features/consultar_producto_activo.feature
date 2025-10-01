Feature: Consultar producto activo

  Scenario: Generar consulta de producto activo
    Given que el servicio de consulta de producto activo está disponible
    When se realiza una solicitud GET al endpoint de producto activo
    Then el servicio responde con un estado ok