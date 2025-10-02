Feature: Consultar usuario

  Scenario: Generar consulta de un usuario
    Given que un cliente autenticado desea obtener la información de un usuario
    When se realiza una solicitud GET al endpoint de usuarios con el identificador del usuario
    Then el servicio responde con el código de estado exitoso y los datos del usuario solicitado
