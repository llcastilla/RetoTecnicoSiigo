Feature: Consultar producto

  Scenario: Generar consulta de los productos
    Given que un cliente autenticado desea obtener un listado de los productos
    When se realiza una solicitud GET al endpoint de los productos
    Then el servicio responde con el código de estado exitoso y muestra datos del producto
