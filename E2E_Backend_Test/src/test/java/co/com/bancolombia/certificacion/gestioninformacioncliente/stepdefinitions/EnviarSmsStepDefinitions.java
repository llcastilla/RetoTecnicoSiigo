package co.com.bancolombia.certificacion.gestioninformacioncliente.stepdefinitions;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectExistClientApi;
import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.Consumer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class EnviarSmsStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que el servicio de envío de códigos SMS está disponible")
    public void queElServicioDeEnvíoDeCódigosSMSEstáDisponible() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_SMS));

    }
    @When("se envía una solicitud para enviar un código SMS a un destinatario válido")
    public void seEnvíaUnaSolicitudParaEnviarUnCódigoSMSAUnDestinatarioVálido() {
        actor.attemptsTo(Consumer.elServicio(QUERYSMS));

    }
    @Then("el código SMS se envía de forma correcta")
    public void elCódigoSMSSeEnvíaDeFormaCorrecta() {
        actor.should(seeThatResponse("",response->response.statusCode(ESTADO_OK)));
    }


    @When("se envía una solicitud para enviar un código SMS sin proporcionar los datos requeridos")
    public void seEnvíaUnaSolicitudParaEnviarUnCódigoSMSSinProporcionarLosDatosRequeridos() {
        actor.attemptsTo(Consumer.elServicio(QUERYSMSERROR));

    }

    @Then("el servicio responde con un código de estado que indica error por datos inválidos")
    public void elServicioRespondeConUnCódigoDeEstadoQueIndicaErrorPorDatosInválidos() {
        actor.should(seeThatResponse("",response->response.statusCode(ESTADO_SERVICIO_422)));

    }
}
