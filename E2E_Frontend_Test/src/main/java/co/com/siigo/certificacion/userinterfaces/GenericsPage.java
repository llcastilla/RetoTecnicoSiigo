package co.com.siigo.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class GenericsPage {
    public static final Target BTN_CONTINUE = Target.the("Botón enviar formulario")
            .locatedBy("//button[@id='siigoNext']");
    public static final Target BTN_CONTINUE2 = Target.the("Botón enviar formulario")
            .locatedBy("//button[text()='Continuar']");
    public static final Target BTN_SEND = Target.the("Botón enviar formulario")
            .locatedBy("//button[.//span[text()='Descargar y guardar']]");
    public static final Target BTN_ACCEPT = Target.the("Campo para seleccionar la Ciudad de Medellín")
            .locatedBy("//button[normalize-space(text())='Aceptar']");
    public static final Target BTN_COMPLETE = Target.the("Botón COMPLETAR formulario")
            .locatedBy("//span[text()='Completar']");
    private GenericsPage() {



    }
}
