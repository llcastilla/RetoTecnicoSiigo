package co.com.siigo.certificacion.tasks;

import co.com.siigo.certificacion.models.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.siigo.certificacion.userinterfaces.login.OpenFrontCollections.SELECT_PROCEDURE_BUTTON;

public class ProductsAndServices implements Task {
    private final Login login;

    public ProductsAndServices(Login login) {
        this.login = login;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(SELECT_PROCEDURE_BUTTON.of(login.getTramite()))
        );
    }

    public static ProductsAndServices delTramite(Login login) {
        return Tasks.instrumented(ProductsAndServices.class, login);
    }
}
