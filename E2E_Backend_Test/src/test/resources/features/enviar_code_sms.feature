Feature: Enviar código SMS

  Scenario: Enviar un código SMS de forma exitosa
    Given que el servicio de envío de códigos SMS está disponible
    When se envía una solicitud para enviar un código SMS a un destinatario válido
    Then el código SMS se envía de forma correcta


  Scenario: Fallo al enviar un código SMS por datos vacíos
    Given que el servicio de envío de códigos SMS está disponible
    When se envía una solicitud para enviar un código SMS sin proporcionar los datos requeridos
    Then el servicio responde con un código de estado que indica error por datos inválidos
