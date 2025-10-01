package co.com.siigo.certificacion.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;


public class ValidationMessagesPage {



    public static final Target TEXTO_BIENVENIDA = Target.the("Texto dentro del Shadow DOM")
            .located(By.cssSelector("panel-atom[title-panel*='Te damos la bienvenida, ¿Qué deseas hacer?']"));

    public static final Target TEXTO_CREDENCIALES_INCORRECTAS = Target.the("Texto dentro del Shadow DOM")
            .locatedBy("(//p[contains(text(),'Usuario o contraseña inválidos')])[2]");

    public static final Target ALERTA_TERCERO_GUARDADO = Target.the("Alerta de confirmación")
            .located(By.xpath("//div[@role='alertdialog' and contains(text(),'Tercero guardado exitosamente')]"));

    private ValidationMessagesPage() {

    }
}
