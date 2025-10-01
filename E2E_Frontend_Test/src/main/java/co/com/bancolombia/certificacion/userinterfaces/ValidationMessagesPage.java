package co.com.bancolombia.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;

public class ValidationMessagesPage {
    public static final Target FAIL_MESSAJE_INITIALDEPOSIT = Target.the("Mensaje fallido de monto inicial")
            .located(id("PRO_detDeposito_inicial-helper-text"));

    public static final Target SUCCESSMESSAJE = Target.the("Mensaje")
            .locatedBy("//h4[contains(text(),'Has finalizado tu solicitud con éxito.')]");

    public static final Target FAIL_MESSAJE_INITIAL_TERM_DEPOSIT = Target.the("Mensaje fallido de monto inicial")
            .located(id("PRO_MontoDeposito-helper-text"));

    public static final Target SUCCESSMESSAJELINK = Target.the("Mensaje")
            .locatedBy("//h2[normalize-space()='PRUEBA AUTOMATIZADA CARGA MANUAL']");

    public static final Target SUCCESSMESSAJELINKFORMDIGITAL = Target.the("Mensaje combos")
            .locatedBy("//h2[normalize-space()='PRUEBA FORM DIGITAL AUTOMATIZADO']");

    public static final Target SUCCESSMESSAJELINK_PJ = Target.the("Mensaje")
            .locatedBy("//h4[contains(text(),'Ha finalizado la firma de los documentos')]");

    public static final Target FAIL_MESSAJE_DATEWRONG = Target.the("Mensaje fallido de fecha de creacion invalida")
            .locatedBy("//p[contains(text(),'Fecha no válida')]");

    public static final Target FAIL_MESSAJE_FILE_OTHER_PDF = Target.the("Mensaje fallido de formato adjunto no valido")
            .locatedBy("//p[contains(text(),'El archivo no tiene el formato permitido!')]");

    public static final Target FAIL_MESSAJE_FILE_EXCEEDS_SIZE = Target.the("Mensaje fallido cuando el PDF supera el tamaño maximo")
            .locatedBy("//p[contains(text(),'El archivo supera las 2MB permitidas!')]");

    private ValidationMessagesPage(){

    }
}
