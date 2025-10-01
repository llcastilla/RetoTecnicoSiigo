package co.com.bancolombia.certificacion.tasks.natural_person;


import co.com.bancolombia.certificacion.interactions.StopWatch;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.bancolombia.certificacion.userinterfaces.natural_person.OpenYourFormPage.*;

public class OpenForm implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                StopWatch.inSeconds(6),
                Click.on(BTN_UPLOAD_DOCUMENT)
        );
    }

    public static OpenForm delFormulariofront() {
        return Tasks.instrumented(OpenForm.class);
    }
}
