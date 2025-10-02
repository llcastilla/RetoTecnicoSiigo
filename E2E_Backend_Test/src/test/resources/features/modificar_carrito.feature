Feature: Modificar carrito

  Scenario: Generar modificación de un carrito
    Given que un cliente autenticado tiene un carrito existente
    When se realiza una solicitud PUT al endpoint de carrito con la información actualizada
    Then el servicio responde con el código de estado exitoso y el carrito se modifica correctamente
