package co.com.siigo.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class GenericsPage {
    public static final Target BTN_CONTINUE = Target.the("Botón enviar formulario")
            .locatedBy("//button[@id='siigoNext']");


    private GenericsPage() {



    }
}
