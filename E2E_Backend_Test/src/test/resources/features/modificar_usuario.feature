Feature: Modificar usuario

  Scenario: Generar modificación de un usuario
    Given que un cliente autenticado tiene un usuario existente a modificar
    When se realiza una solicitud PUT al endpoint de usuarios con la información actualizada
    Then el servicio responde con el código de estado exitoso y el usuario se modifica correctamente
