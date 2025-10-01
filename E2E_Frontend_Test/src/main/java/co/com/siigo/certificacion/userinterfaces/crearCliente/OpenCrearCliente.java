package co.com.siigo.certificacion.userinterfaces.crearCliente;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;


public class OpenCrearCliente {

    public static final Target BOTON_CREAR = Target.the("Botón Crear dentro del Shadow DOM")
            .located(ByShadow.cssSelector(
                    "button.btn-element", // selector interno
                    "siigo-header-molecule", // primer shadow host
                    "siigo-button-atom[data-id='header-create-button']" // segundo shadow host
            ));

    public static final Target LINK_CLIENTES = Target.the("Enlace Clientes dentro del Shadow DOM")
            .located(ByShadow.cssSelector(
                    "a[data-value='Clientes']",     // selector dentro del Shadow DOM
                    "siigo-header-molecule"         // shadow host
            ));



}
