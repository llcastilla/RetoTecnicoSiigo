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


import static co.com.siigo.certificacion.userinterfaces.ValidationMessagesPage.SUCCESSMESSAJELINK;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

@Subject("Mensaje de finalización de completado la solicitud")
public class SuccessMessageLink implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                Scroll.to(SUCCESSMESSAJELINK),
                WaitUntil.the(SUCCESSMESSAJELINK, isPresent()).forNoMoreThan(20).seconds()
        );

        // Aplica zoom al 50%
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");

        // Obtiene el texto del mensaje
        String message = Text.of(SUCCESSMESSAJELINK).answeredBy(actor);

        return Constants.MESSAGESUCCESLINK.getMessage().equals(message);
    }

    public static SuccessMessageLink ofFinishingSuccessful() {
        return new SuccessMessageLink();
    }
}