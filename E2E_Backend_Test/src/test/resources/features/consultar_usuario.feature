Feature: Consultar usuario general

  Scenario: Generar consulta de la lista de clientes
    Given que un cliente autenticado desea obtener información de los usuarios registrados
    When se realiza una solicitud GET al endpoint
    Then el servicio responde con el código de estado exitoso