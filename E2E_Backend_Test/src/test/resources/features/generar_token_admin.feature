Feature: Generar token de autenticación admin

  Scenario: Generar token válido para consumo de servicios admin
    Given que se requiere generar un token de autenticación para el admin
    When se suministran las credenciales correspondientes del admin
    Then se obtiene un token válido que puede ser utilizado para las consultas

  Scenario: Generar token válido para consumo de servicios admin fallido
    Given que se requiere generar un token de autenticación para el admin
    When se suministran las credenciales incorrectas correspondientes del admin
    Then se obtiene un mensaje indicando que no se puede logear