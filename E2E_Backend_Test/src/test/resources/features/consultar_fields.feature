Feature: Consultar fields

  Scenario: Generar consulta de los fields
    Given que un cliente autenticado desea obtener un listado de fields
    When se realiza una solicitud GET al endpoint de fields
    Then el servicio responde con el código de estado exitoso y los datos del fields solicitado
