Feature: Consultar Roles

  Scenario: Generar consulta de la lista de roles
    Given que un cliente autenticado desea obtener información de los roles registrados
    When se realiza una solicitud GET al endpoint de roles
    Then el servicio responde con el código de estado exitoso roles