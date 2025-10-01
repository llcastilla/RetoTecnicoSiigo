Feature: Consultar Formato

  Scenario: Generar consulta de un formato específico por su identificador
    Given que un cliente autenticado desea obtener un formato por su ID
    When se realiza una solicitud GET al endpoint de formatos con un identificador válido
    Then el servicio responde con el código de estado exitoso y los datos del formato solicitado
