Feature: modificar producto

  Scenario: modificar un producto exitosamente con datos válidos
    Given que el servicio  de productos está activo
    When el cliente envía una solicitud patch al endpoint de productos con todos los datos requeridos y un token válido
    Then el servicio responde con el código de estado HTTP

