package co.com.siigo.certificacion.stepdefinitions;


import co.com.siigo.certificacion.models.tasks.ConnectExistClientApi;
import co.com.siigo.certificacion.models.tasks.Consumer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.siigo.certificacion.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CrearUsuarioStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que el servicio de creación de usuarios está disponible")
    public void queElServicioDeCreaciónDeUsuariosEstáDisponible() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_PRODUCTO_GET));

    }
    @When("se envía una solicitud POST al endpoint de creación de usuarios con la información requerida")
    public void seEnvíaUnaSolicitudPOSTAlEndpointDeCreaciónDeUsuariosConLaInformaciónRequerida() {
        actor.attemptsTo(Consumer.elServicio(QUERYCREATEUSER));
    }
    @Then("el servicio responde con el código de estado Created")
    public void elServicioRespondeConElCódigoDeEstadoCreated() {
        actor.should(seeThatResponse("",response->response.statusCode(ESTADO_OK)));
    }

    @When("se envía una solicitud POST al endpoint de creación de usuarios con la información requerida sin el token")
    public void seEnvíaUnaSolicitudPOSTAlEndpointDeCreaciónDeUsuariosConLaInformaciónRequeridaSinElToken() {
        actor.attemptsTo(Consumer.elServicio(QUERYCREATEUSER));

    }

    @Then("el servicio responde con el código de estado fallido")
    public void elServicioRespondeConElCódigoDeEstadoFallido() {
        actor.should(seeThatResponse("",response->response.statusCode(ESTADO_SERVICIO_500)));

    }
}
