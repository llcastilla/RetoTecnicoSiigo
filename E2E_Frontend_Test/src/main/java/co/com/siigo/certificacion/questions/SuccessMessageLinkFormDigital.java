package co.com.siigo.certificacion.questions;

import co.com.siigo.certificacion.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static co.com.siigo.certificacion.userinterfaces.ValidationMessagesPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
@Subject("Mensaje de finalización de completado la solicitud")
public class SuccessMessageLinkFormDigital implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        // Esperar a que el mensaje esté presente
        actor.attemptsTo(
                WaitUntil.the(SUCCESSMESSAJELINKFORMDIGITAL, isPresent()).forNoMoreThan(10L).seconds(),
                Scroll.to(SUCCESSMESSAJELINKFORMDIGITAL)
        );

        // Bajar el zoom al 50%
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");

        // Capturar el mensaje y compararlo
        String message = Text.of(SUCCESSMESSAJELINKFORMDIGITAL).answeredBy(actor);
        return Constants.MENSAJEOK.getMessage().equals(message);
    }

    public static SuccessMessageLinkFormDigital ofFinishingSuccessful() {
        return new SuccessMessageLinkFormDigital();
    }
}