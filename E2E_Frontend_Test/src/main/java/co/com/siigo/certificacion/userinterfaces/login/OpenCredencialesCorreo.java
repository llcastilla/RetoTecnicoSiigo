package co.com.siigo.certificacion.userinterfaces.login;

import net.serenitybdd.screenplay.targets.Target;

public class OpenCredencialesCorreo {
    public static final Target BOTON_CORREO = Target.the("Checbox para seleccionar tramite")
            .locatedBy("//input[@id='siigoSignInName']");
    public static final Target BOTON_CONTRA = Target.the("Checbox para seleccionar tramite")
            .locatedBy("//input[@id='siigoPassword']");

    private OpenCredencialesCorreo() {

    }
}
