package co.com.siigo.certificacion.tasks;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.siigo.certificacion.userinterfaces.crearCliente.OpenCrearCliente.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class NavegarAClientesTerceros extends PageObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BOTON_CREAR, isPresent()).forNoMoreThan(15).seconds(),
                Click.on(BOTON_CREAR),
                WaitUntil.the(LINK_CLIENTES, isPresent()).forNoMoreThan(15).seconds(),
                Click.on(LINK_CLIENTES)

        );


    }

    public static NavegarAClientesTerceros delFormulariofront() {
        return Tasks.instrumented(NavegarAClientesTerceros.class);
    }
}
