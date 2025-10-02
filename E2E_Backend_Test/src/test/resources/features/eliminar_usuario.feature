Feature: Eliminar usuario

  Scenario: Generar eliminación de un usuario
    Given que un cliente autenticado tiene un usuario existente a eliminar
    When se realiza una solicitud DELETE al endpoint de usuarios con el identificador del usuario
    Then el servicio responde con el código de estado exitoso y el usuario se elimina correctamente
