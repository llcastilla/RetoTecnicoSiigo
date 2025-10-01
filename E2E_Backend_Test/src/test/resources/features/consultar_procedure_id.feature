Feature: Consultar Procedimientos

  Scenario: Generar consulta de la lista de procedimientos
    Given que un cliente autenticado desea obtener información de los procedimientos registrados
    When se realiza una solicitud GET al endpoint de procedimientos
    Then el servicio responde con el código de estado exitoso procedimientos