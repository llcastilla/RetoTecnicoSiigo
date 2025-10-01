package co.com.siigo.certificacion.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

import static org.openqa.selenium.By.id;

public class ValidationMessagesPage {


    public static final Target SUCCESSMESSAJELINK = Target.the("Mensaje")
            .locatedBy("//h2[normalize-space()='PRUEBA AUTOMATIZADA CARGA MANUAL']");


    public static final Target SUCCESSMESSAJELINKFORMDIGITAL = Target.the("texto de bienvenida")
            .located(ByShadow.cssSelector(
                    "div.size-l.siigo-panel-header-text p",      // selector dentro del Shadow DOM
                    "#wc-3ad2be6f-db51-475f-87e2-b2a9f911c8ce"   // shadow host
            ));

    public static final Target TEXTO_BIENVENIDA = Target.the("Texto dentro del Shadow DOM")
            .located(By.cssSelector("panel-atom[title-panel*='Te damos la bienvenida, ¿Qué deseas hacer?']"));

    public static final Target TEXTO_CREDENCIALES_INCORRECTAS = Target.the("Texto dentro del Shadow DOM")
            .locatedBy("(//p[contains(text(),'Usuario o contraseña inválidos')])[2]");



    private ValidationMessagesPage() {

    }
}
