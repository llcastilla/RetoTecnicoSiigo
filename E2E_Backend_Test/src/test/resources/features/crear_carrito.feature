Feature: Crear carrito

  Scenario: Generar creación de un carrito
    Given que un cliente autenticado desea crear un carrito
    When se realiza una solicitud POST al endpoint de carrito con la información requerida
    Then el servicio responde con el código de estado exitoso y el carrito es creado correctamente
