package co.com.siigo.certificacion.userinterfaces.login;

import net.serenitybdd.screenplay.targets.Target;

public class UploadDocumentPage {
    public static final Target BTN_SELECT_FILE = Target.the("Seleccionar archivo")
            .locatedBy("//input[@type='file']");
    public static final Target CHECK_CLAUSULAS = Target.the("Seleccionar archivo")
            .locatedBy("//input[@type='checkbox']");

    public static final Target BTN_FINALIZAR = Target.the("Seleccionar archivo")
            .locatedBy("//button[normalize-space()='Finalizar']");



    private UploadDocumentPage() {

    }
}
