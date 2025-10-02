Feature: Crear usuario

  Scenario: Generar creación de un usuario
    Given que un cliente autenticado desea registrar un nuevo usuario
    When se realiza una solicitud POST al endpoint de usuarios con la información requerida
    Then el servicio responde con el código de estado exitoso y el usuario es creado correctamente
