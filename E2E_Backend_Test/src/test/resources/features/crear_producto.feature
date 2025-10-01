Feature: Crear un nuevo producto

  Scenario: Crear un producto exitosamente con datos válidos
    Given que el servicio de gestión de productos está activo
    When el cliente envía una solicitud POST al endpoint de productos con todos los datos requeridos y un token válido
    Then el servicio responde con el código de estado HTTP Created

  Scenario: Intento fallido de creación de producto por token ausente o vencido
    Given que el servicio de gestión de productos está activo
    When el cliente realiza una solicitud POST al endpoint de productos con los datos requeridos pero sin incluir un token válido
    Then el servicio responde con un código de estado HTTP de error, indicando autorización fallida
