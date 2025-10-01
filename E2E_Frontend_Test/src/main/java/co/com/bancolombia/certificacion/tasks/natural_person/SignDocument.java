package co.com.bancolombia.certificacion.tasks.natural_person;

import co.com.bancolombia.certificacion.userinterfaces.GenericsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.userinterfaces.natural_person.UploadDocumentPage.BTN_FINALIZAR;
import static co.com.bancolombia.certificacion.userinterfaces.natural_person.UploadDocumentPage.CHECK_CLAUSULAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SignDocument implements Task {
    public SignDocument() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(GenericsPage.BTN_CONTINUE2, isEnabled()),
                Click.on(GenericsPage.BTN_CONTINUE2),
                Click.on(CHECK_CLAUSULAS),
                Click.on(BTN_FINALIZAR)
        );
    }

    public static SignDocument documents() {
        return Tasks.instrumented(SignDocument.class);
    }
}
