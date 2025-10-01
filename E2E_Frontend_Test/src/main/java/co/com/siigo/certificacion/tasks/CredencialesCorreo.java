package co.com.siigo.certificacion.tasks;

import co.com.siigo.certificacion.models.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.siigo.certificacion.userinterfaces.GenericsPage.BTN_CONTINUE;
import static co.com.siigo.certificacion.userinterfaces.login.OpenCredencialesCorreo.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;


public class CredencialesCorreo implements Task {
    private final Login login;

    public CredencialesCorreo(Login login) {
        this.login = login;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BOTON_CORREO, isPresent()).forNoMoreThan(20).seconds(),
                Enter.theValue(login.getCorreo()).into(BOTON_CORREO),
                Enter.theValue(login.getContrasena()).into(BOTON_CONTRA),
                Click.on(BTN_CONTINUE)

        );
    }

    public static CredencialesCorreo delTramite(Login login) {
        return Tasks.instrumented(CredencialesCorreo.class, login);
    }
}
