package co.com.siigo.certificacion.tasks;

import co.com.siigo.certificacion.interactions.StopWatch;
import co.com.siigo.certificacion.models.DataCliente;
import co.com.siigo.certificacion.userinterfaces.crearCliente.ClientePageForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static co.com.siigo.certificacion.userinterfaces.crearCliente.ClientePageForm.*;
import static co.com.siigo.certificacion.userinterfaces.login.OpenCredencialesCorreo.BOTON_CORREO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistrarCliente implements Task {
private final DataCliente dataCliente;
    public RegistrarCliente(DataCliente dataCliente ) {
        this.dataCliente = dataCliente;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Esperar a que el checkbox esté presente
        actor.attemptsTo(
                WaitUntil.the(CHECKBOX_IS_CLIENT, isPresent()).forNoMoreThan(10).seconds(),
                WaitUntil.the(LISTADO_TIPO, isPresent()).forNoMoreThan(10).seconds(),
                WaitUntil.the(OPCION_ES_PERSONA, isPresent()).forNoMoreThan(10).seconds()


        );

        // Validar si el checkbox NO está seleccionado
        Boolean estaSeleccionado = CHECKBOX_IS_CLIENT.resolveFor(actor).isSelected();

        if (!estaSeleccionado) {
            actor.attemptsTo(
                    Click.on(CHECKBOX_IS_CLIENT)
            );
        }
        actor.attemptsTo(
                Click.on(LISTADO_TIPO),
                Click.on(OPCION_ES_PERSONA),
                Enter.theValue(dataCliente.getNumId()).into(INPUT_IDENTIFICACION),
                Click.on(AUTOCOMPLETAR_DATOS),
                StopWatch.inSeconds(8),
                Enter.theValue(dataCliente.getCodSucursal()).into(INPUT_SUCURSAL)




                );


    }

    public static RegistrarCliente registrarCliente(DataCliente dataCliente) {
        return Tasks.instrumented(RegistrarCliente.class, dataCliente);
    }
}