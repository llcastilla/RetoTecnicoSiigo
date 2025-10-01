@E2E
Feature: Flujo E2E - Crear cliente tercero
  Como usuario del sistema
  Quiero registrar clientes terceros
  Para que queden disponibles en el sistema de gestión

  @ClienteTerceroExitoso
  Scenario Outline: Crear cliente exitoso en el formulario
    Given el usuario inicia sesión <login>
    When completa todos los campos obligatorios con datos válidos <data>
    And selecciona "No responsable de IVA" con responsabilidad "R-99-PN"
    And hace clic en "Guardar"
    Then el sistema muestra "Cliente creado exitosamente"
    And el registro aparece en la lista con Código sucursal "<codigo_sucursal>"

    Examples:
      | login     |
      | dataLogin |

  @ClienteTerceroValidaciones
  Scenario Outline: Intentar crear cliente con múltiples validaciones inválidas
    Given el usuario abre el formulario de clientes
    When ingresa información inválida <data>
    And completa los demás campos obligatorios correctamente
    Then el sistema muestra mensajes de validación en Identificación, Código de la sucursal y Teléfono
    And el cliente no es creado

    Examples:
      | data                                                                   |
      | {"Identificación":"12","Código sucursal":"12","Teléfono":"1423423423"} |