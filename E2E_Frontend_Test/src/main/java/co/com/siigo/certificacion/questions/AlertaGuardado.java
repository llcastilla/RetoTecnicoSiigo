package co.com.siigo.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.siigo.certificacion.userinterfaces.ValidationMessagesPage.ALERTA_TERCERO_GUARDADO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AlertaGuardado implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        // Espera hasta que la alerta sea visible
        actor.attemptsTo(
                WaitUntil.the(ALERTA_TERCERO_GUARDADO, isVisible()).forNoMoreThan(10).seconds()
        );

        // Retorna el texto de la alerta
        return ALERTA_TERCERO_GUARDADO.resolveFor(actor).getText().trim();
    }

    public static Question<String> es() {
        return new AlertaGuardado();
    }
}
