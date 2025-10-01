package co.com.siigo.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.siigo.certificacion.userinterfaces.ValidationMessagesPage.TEXTO_CREDENCIALES_INCORRECTAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MensajeErrorLogin implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        // Esperar a que el mensaje sea visible
        actor.attemptsTo(
                WaitUntil.the(TEXTO_CREDENCIALES_INCORRECTAS, isVisible()).forNoMoreThan(10).seconds()
        );

        // Extraer y limpiar la primera línea del mensaje
        String texto = TEXTO_CREDENCIALES_INCORRECTAS.resolveFor(actor).getText();
        return texto.split("\\r?\\n")[0].trim();
    }

    public static Question<String> es() {
        return new MensajeErrorLogin();
    }
}
