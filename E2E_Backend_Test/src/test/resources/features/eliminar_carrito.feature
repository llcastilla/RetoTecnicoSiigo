Feature: Eliminar carrito

  Scenario: Generar eliminación de un carrito
    Given que un cliente autenticado tiene un carrito existente para eliminar
    When se realiza una solicitud DELETE al endpoint de carrito
    Then el servicio responde con el código de estado exitoso y el carrito se elimina correctamente
