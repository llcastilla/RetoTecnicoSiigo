package co.com.siigo.certificacion.tasks;

import co.com.siigo.certificacion.interactions.StopWatch;
import co.com.siigo.certificacion.models.Contacto;
import co.com.siigo.certificacion.models.DataCliente;
import co.com.siigo.certificacion.userinterfaces.crearCliente.ClientePageForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static co.com.siigo.certificacion.userinterfaces.crearCliente.ClientePageForm.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistrarCliente implements Task {
    private final DataCliente dataCliente;
    private final Contacto contacto;

    public RegistrarCliente(DataCliente dataCliente, Contacto contacto) {
        this.dataCliente = dataCliente;
        this.contacto = contacto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        // Esperar a que el checkbox esté presente
        actor.attemptsTo(
                WaitUntil.the(CHECKBOX_IS_CLIENT, isPresent()).forNoMoreThan(10).seconds()
        );

        // Validar si el checkbox NO está seleccionado
        Boolean estaSeleccionado = CHECKBOX_IS_CLIENT.resolveFor(actor).isSelected();

        if (!estaSeleccionado) {
            actor.attemptsTo(
                    Click.on(CHECKBOX_IS_CLIENT)
            );
        }
        actor.attemptsTo(
                WaitUntil.the(LISTADO_TIPO, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(LISTADO_TIPO),
                WaitUntil.the(OPCION_ES_PERSONA, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(OPCION_ES_PERSONA),
                Enter.theValue(dataCliente.getNumId()).into(INPUT_IDENTIFICACION),
                Click.on(AUTOCOMPLETAR_DATOS),
                StopWatch.inSeconds(5),
                Enter.theValue(dataCliente.getCodSucursal()).into(INPUT_SUCURSAL),
                Enter.theValue(dataCliente.getNombreComercial()).into(INPUT_NOMBRE_COMERCIAL),
                Enter.theValue(dataCliente.getDireccion()).into(INPUT_DIRECCION),
                Enter.theValue(dataCliente.getIndicativo()).into(INPUT_INDICATIVO),
                Enter.theValue(dataCliente.getTelefono()).into(INPUT_TELEFONO),
                Enter.theValue(dataCliente.getExt()).into(INPUT_EXTENSION),
                Click.on(INPUT_REGIMEN),
                Click.on(INPUT_REGIMEN_SEL),
                Enter.theValue(dataCliente.getIndicativo()).into(INPUT_REGIMEN_INDICATIVO),
                Enter.theValue(dataCliente.getTelefono()).into(INPUT_REGIMEN_TELEFONO),
                Enter.theValue(dataCliente.getCodigoPostal()).into(INPUT_CODIGO_POSTAL),
                Click.on(H3_CONTACTO),
                StopWatch.inSeconds(2),
                Enter.theValue(contacto.getNombre()).into(INPUT_NOMBRE),
                Enter.theValue(contacto.getApellido()).into(INPUT_APELLIDO),
                Enter.theValue(contacto.getCorreo()).into(INPUT_CORREO),
                Enter.theValue(contacto.getCargo()).into(INPUT_CARGO),
                Enter.theValue(contacto.getIndicativo()).into(INPUT_INDICATIVO_CONTACTO),
                Enter.theValue(contacto.getTelefono()).into(INPUT_TELEFONO_CONTACTO)
                );


    }

    public static RegistrarCliente registrarCliente(DataCliente dataCliente, Contacto contacto) {
        return Tasks.instrumented(RegistrarCliente.class, dataCliente, contacto);
    }
}