package co.com.siigo.certificacion.utils;

public enum Constants {
    MESSAGE("Has finalizado tu solicitud con éxito."),
    MESSAGESUCCESLINK("PRUEBA AUTOMATIZADA CARGA MANUAL"),
    MESSAGESUCCESLINKFORMDIGITAL("PRUEBA FORM DIGITAL AUTOMATIZADO"),
    MESSAGESUCCESLINK_PJ("Ha finalizado la firma de los documentos"),
    MESSAGE_FAIL_INITIAL_DEPOSIT("El deposito inicial debe ser mínimo de USD "),
    MESSAGE_FAIL_INITIAL_TERM_DEPOSIT("El monto mínimo del depósito debe ser de USD"),
    MESSAGE_FAIL_DATE_WRONG("Fecha no válida"),
    FAIL_MESSAJE_FILE_OTHER_PDF("El archivo no tiene el formato permitido!"),
    FAIL_MESSAJE_FILE_EXCEEDS_SIZE("El archivo supera las 2MB permitidas!"),

    TARGETLISTBENEFIT("//li[@data-value='{0}']"),
    OPTION_NO("No"),
    CONSTANT_TRUE("true"),
    OPTION_SI("Sí"),
    NUMBER_100("100"),
    ERROR_WHEN_CREATING_ACCOUNT("El proceso de solicitud de cuenta Falló");


    final String constant;

    Constants(String constants) {
        this.constant = constants;
    }

    public String getMessage(){return constant;}
}
