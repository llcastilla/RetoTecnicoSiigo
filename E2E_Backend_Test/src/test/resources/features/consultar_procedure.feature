Feature: Consultar Procedimiento por ID

  Scenario: Generar consulta de un procedimiento específico por su identificador
    Given que un cliente autenticado desea obtener un procedimiento por su ID
    When se realiza una solicitud GET al endpoint de procedimientos con un identificador válido
    Then el servicio responde con el código de estado exitoso y los datos del procedimiento solicitado
