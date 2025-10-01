package co.com.bancolombia.certificacion.gestioninformacioncliente.stepdefinitions;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectExistClientApi;
import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.Consumer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CrearProductoStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que el servicio de gestión de productos está activo")
    public void queElServicioDeGestiónDeProductosEstáActivo() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_CREAR_PRODUCTO));

    }

    @When("el cliente envía una solicitud POST al endpoint de productos con todos los datos requeridos y un token válido")
    public void elClienteEnvíaUnaSolicitudPOSTAlEndpointDeProductosConTodosLosDatosRequeridosYUnTokenVálido() {
        actor.attemptsTo(Consumer.elServicio(QUERYPRODUCTO));

    }

    @Then("el servicio responde con el código de estado HTTP Created")
    public void elServicioRespondeConElCódigoDeEstadoHTTPCreated() {
        actor.should(seeThatResponse("", response -> response.statusCode(ESTADO_OK)));

    }

    @When("el cliente realiza una solicitud POST al endpoint de productos con los datos requeridos pero sin incluir un token válido")
    public void elClienteRealizaUnaSolicitudPOSTAlEndpointDeProductosConLosDatosRequeridosPeroSinIncluirUnTokenVálido() {
        actor.attemptsTo(Consumer.elServicio(QUERYPRODUCTOERROR));

    }


    @Then("el servicio responde con un código de estado HTTP de error, indicando autorización fallida")
    public void elServicioRespondeConUnCódigoDeEstadoHTTPDeErrorIndicandoAutorizaciónFallida() {
        actor.should(seeThatResponse("", response -> response.statusCode(ESTADO_SERVICIO_EXISTE)));

    }
}
