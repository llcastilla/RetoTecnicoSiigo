Feature: Crear un nuevo usuario

  Scenario: Generar creación de un usuario con datos válidos
    Given que el servicio de creación de usuarios está disponible
    When se envía una solicitud POST al endpoint de creación de usuarios con la información requerida
    Then el servicio responde con el código de estado Created

  Scenario: Generar creación de un usuario con token vencido
    Given que el servicio de creación de usuarios está disponible
    When se envía una solicitud POST al endpoint de creación de usuarios con la información requerida sin el token
    Then el servicio responde con el código de estado fallido