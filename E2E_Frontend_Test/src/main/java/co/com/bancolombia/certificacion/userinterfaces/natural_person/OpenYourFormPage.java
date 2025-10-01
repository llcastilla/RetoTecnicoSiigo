package co.com.bancolombia.certificacion.userinterfaces.natural_person;

import net.serenitybdd.screenplay.targets.Target;


public class OpenYourFormPage {


    public static final Target BTN_UPLOAD_DOCUMENT = Target.the("Botón para seleccionar tipo de cuenta Ahorros/Corriente")
            .locatedBy("//button[@role='menuitem' and contains(., 'Iniciar trámite')]");


    private OpenYourFormPage() {

    }

}
