package co.com.bancolombia.certificacion.tasks.natural_person;

import co.com.bancolombia.certificacion.interactions.StopWatch;
import co.com.bancolombia.certificacion.models.natural_person.ContactData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.bancolombia.certificacion.userinterfaces.natural_person.OpenFrontCollections.SELECT_PROCEDURE_BUTTON;

public class ProductsAndServices implements Task {
    private final ContactData contactData;

    public ProductsAndServices(ContactData contactData) {
        this.contactData = contactData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(SELECT_PROCEDURE_BUTTON.of(contactData.getTramite()))
        );
    }

    public static ProductsAndServices delTramite(ContactData contactData) {
        return Tasks.instrumented(ProductsAndServices.class, contactData);
    }
}
