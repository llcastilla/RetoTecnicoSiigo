Feature: Consultar carrito

  Scenario: Generar consulta del carrito
    Given que un cliente autenticado desea obtener la información de su carrito
    When se realiza una solicitud GET al endpoint de carrito
    Then el servicio responde con el código de estado exitoso y los datos del carrito solicitado
