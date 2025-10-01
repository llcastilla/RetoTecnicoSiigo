package co.com.bancolombia.certificacion.gestioninformacioncliente.stepdefinitions;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectExistClientApi;
import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultarProductoIdStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que el servicio de consulta de producto está disponible")
    public void queElServicioDeConsultaDeProductoEstáDisponible() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_PRODUCTO));

    }

    @When("se realiza una solicitud GET al endpoint de producto por id")
    public void seRealizaUnaSolicitudGETAlEndpointDeProductoPorId() {
        actor.attemptsTo(ConnectUser.alServicio());

    }
    @Then("el servicio responde con el código de estado")
    public void elServicioRespondeConElCódigoDeEstado() {
        actor.should(seeThatResponse("", response -> response.statusCode(ESTADO_SERVICIO_OK)));

    }



}
