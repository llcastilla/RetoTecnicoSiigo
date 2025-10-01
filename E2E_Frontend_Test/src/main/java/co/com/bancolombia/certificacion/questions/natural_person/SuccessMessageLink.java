package co.com.bancolombia.certificacion.questions.natural_person;

import co.com.bancolombia.certificacion.interactions.StopWatch;
import co.com.bancolombia.certificacion.userinterfaces.GenericsPage;
import co.com.bancolombia.certificacion.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import static co.com.bancolombia.certificacion.userinterfaces.ValidationMessagesPage.SUCCESSMESSAJELINK;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

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