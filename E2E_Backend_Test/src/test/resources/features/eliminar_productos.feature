Feature: eliminar producto

  Scenario: eliminar producto
    Given que un cliente autenticado desea eliminar un producto
    When se realiza una solicitud DELETE al endpoint de producto
    Then el servicio responde con el código de estado OK
