package co.com.siigo.certificacion.tasks;


import co.com.siigo.certificacion.interactions.StopWatch;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.siigo.certificacion.userinterfaces.login.OpenYourFormPage.*;

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
