package co.com.siigo.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.siigo.certificacion.userinterfaces.ValidationMessagesPage.TEXTO_BIENVENIDA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MensajeBienvenidaDashboard implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        // Espera hasta que aparezca el texto de bienvenida
        actor.attemptsTo(
                WaitUntil.the(TEXTO_BIENVENIDA, isVisible()).forNoMoreThan(10).seconds()
        );

        // Extrae y limpia la primera línea
        String texto = TEXTO_BIENVENIDA.resolveFor(actor).getText();
        return texto.split("\\r?\\n")[0].trim();
    }

    public static Question<String> es() {
        return new MensajeBienvenidaDashboard();
    }
}
