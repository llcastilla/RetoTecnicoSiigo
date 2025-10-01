package co.com.siigo.certificacion.tasks;

import co.com.siigo.certificacion.models.LoginError;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.siigo.certificacion.userinterfaces.GenericsPage.BTN_CONTINUE;
import static co.com.siigo.certificacion.userinterfaces.login.OpenCredencialesCorreo.BOTON_CONTRA;
import static co.com.siigo.certificacion.userinterfaces.login.OpenCredencialesCorreo.BOTON_CORREO;


public class CredencialesCorreoInvalido implements Task {
    private final LoginError loginError;

    public CredencialesCorreoInvalido( LoginError loginError) {
        this.loginError = loginError;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Enter.theValue(loginError.getCorreo()).into(BOTON_CORREO),
                Enter.theValue(loginError.getContrasena()).into(BOTON_CONTRA),
                Click.on(BTN_CONTINUE)

        );
    }

    public static CredencialesCorreoInvalido delTramite( LoginError loginError) {
        return Tasks.instrumented(CredencialesCorreoInvalido.class, loginError);
    }
}
