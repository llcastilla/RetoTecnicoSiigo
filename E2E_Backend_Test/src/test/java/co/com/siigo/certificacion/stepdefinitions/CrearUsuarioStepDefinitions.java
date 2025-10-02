package co.com.siigo.certificacion.stepdefinitions;


import co.com.siigo.certificacion.models.tasks.ConnectExistClientApi;
import co.com.siigo.certificacion.models.tasks.Consumer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static org.hamcrest.Matchers.*;

import static co.com.siigo.certificacion.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CrearUsuarioStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que un cliente autenticado desea registrar un nuevo usuario")
    public void queUnClienteAutenticadoDeseaRegistrarUnNuevoUsuario() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_USUARIO));


    }

    @When("se realiza una solicitud POST al endpoint de usuarios con la información requerida")
    public void seRealizaUnaSolicitudPOSTAlEndpointDeUsuariosConLaInformaciónRequerida() {
        actor.attemptsTo(Consumer.elServicio(QUERYUSER));

    }

    @Then("el servicio responde con el código de estado exitoso y el usuario es creado correctamente")
    public void elServicioRespondeConElCódigoDeEstadoExitosoYElUsuarioEsCreadoCorrectamente() {
        actor.should(
                seeThatResponse("El servicio debe responder con código exitoso y retornar el id del usuario creado",
                        response -> response
                                .statusCode(ESTADO_OK) // normalmente sería 201 Created
                                .body("id", notNullValue())
                                .body("id", greaterThan(0))
                )
        );
    }

}
