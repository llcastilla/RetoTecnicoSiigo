@E2E
Feature: Flujo de inicio de sesión
  Como usuario del sistema
  Quiero iniciar sesión con mis credenciales
  Para poder acceder a las funcionalidades de la aplicación

  @LoginExitoso
  Scenario Outline: Iniciar sesión con credenciales válidas
    Given el usuario abre la página de login <data>
    When ingresa credenciales válidas
    Then el sistema redirige al dashboard principal

    Examples:
      | data                                                                |
      |dataLogin |

  @LoginFallido
  Scenario Outline: Intentar iniciar sesión con credenciales inválidas
    Given el usuario abre la página de login <data>
    When ingresa credenciales inválidas
    Then el sistema muestra el mensaje de error Usuario o contraseña incorrectos

    Examples:
      | data     |
      | dataLoginError|