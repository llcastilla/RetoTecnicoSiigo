Feature: Crear un nuevo producto

  Scenario: Crear un producto exitosamente con datos válidos
    Given que el servicio de gestión de productos está activo
    When el cliente envía una solicitud POST al endpoint de productos con todos los datos requeridos y un token válido
    Then el servicio responde con el código de estado HTTP Created
