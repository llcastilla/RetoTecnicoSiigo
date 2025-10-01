package co.com.bancolombia.certificacion.gestioninformacioncliente.stepdefinitions;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectExistClientApi;
import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultarProductoActivoStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que el servicio de consulta de producto activo está disponible")
    public void queElServicioDeConsultaDeProductoActivoEstáDisponible() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_PRODUCTO_ACTIVO));

    }

    @When("se realiza una solicitud GET al endpoint de producto activo")
    public void seRealizaUnaSolicitudGETAlEndpointDeProductoActivo() {
        actor.attemptsTo(ConnectUser.alServicio());

    }


    @Then("el servicio responde con un estado ok")
    public void elServicioRespondeConUnEstadoOk() {
        actor.should(seeThatResponse("", response -> response.statusCode(ESTADO_SERVICIO_OK)));

    }
}
