@E2E
Feature: Flujo E2E - Crear cliente tercero
  Como usuario del sistema
  Quiero registrar clientes terceros
  Para que queden disponibles en el sistema de gestión

  Scenario Outline: Crear un cliente tercero usando datos desde JSON
    Given el usuario se loguea <data>
    When navega a la sección Clientes Terceros
    And ingresa los datos del cliente tercero desde el archivo
    Then el sistema muestra un mensaje de confirmación Cliente tercero creado exitosamente

    Examples:
      | data        |
      | dataCliente |