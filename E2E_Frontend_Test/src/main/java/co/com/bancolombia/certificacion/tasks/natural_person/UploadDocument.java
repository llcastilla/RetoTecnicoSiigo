package co.com.bancolombia.certificacion.tasks.natural_person;

import co.com.bancolombia.certificacion.userinterfaces.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.nio.file.Path;

import static co.com.bancolombia.certificacion.userinterfaces.natural_person.UploadDocumentPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class UploadDocument implements Task {
    Path fileToUpload = Path.of("src/test/resources/documentos/Archivo de Pueba.pdf");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SELECT_FILE, isNotVisible()),
                Upload.theFile(fileToUpload).to(BTN_SELECT_FILE),
                WaitUntil.the(GenericsPage.BTN_CONTINUE2, isEnabled()),
                Click.on(GenericsPage.BTN_CONTINUE2),
                Click.on(CHECK_CLAUSULAS),
                Click.on(BTN_FINALIZAR)


                );
    }

    public static UploadDocument ofSupport() {
        return Tasks.instrumented(UploadDocument.class);
    }
}
