package co.com.siigo.certificacion.stepdefinitions;

import co.com.siigo.certificacion.models.tasks.ConnectExistClientApi;
import co.com.siigo.certificacion.models.tasks.DeleteClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static org.hamcrest.Matchers.*;

import static co.com.siigo.certificacion.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class EliminarUsuarioStepDefinitions {
    Actor actor = Actor.named("tester");

    @Given("que un cliente autenticado tiene un usuario existente a eliminar")
    public void queUnClienteAutenticadoTieneUnUsuarioExistenteAEliminar() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_USUARIO_DEL));

    }

    @When("se realiza una solicitud DELETE al endpoint de usuarios con el identificador del usuario")
    public void seRealizaUnaSolicitudDELETEAlEndpointDeUsuariosConElIdentificadorDelUsuario() {
        actor.attemptsTo(DeleteClass.alServicio());

    }

    @Then("el servicio responde con el código de estado exitoso y el usuario se elimina correctamente")
    public void elServicioRespondeConElCódigoDeEstadoExitosoYElUsuarioSeEliminaCorrectamente() {
        actor.should(
                seeThatResponse("El servicio debe responder con 200 OK y devolver los datos del usuario eliminado",
                        response -> response
                                .statusCode(ESTADO_SERVICIO_OK)
                                .body("id", notNullValue())
                                .body("email", not(isEmptyOrNullString()))
                                .body("username", not(isEmptyOrNullString()))
                                .body("password", not(isEmptyOrNullString()))
                                .body("name.firstname", not(isEmptyOrNullString()))
                                .body("name.lastname", not(isEmptyOrNullString()))
                                .body("phone", not(isEmptyOrNullString()))
                                .body("address.city", not(isEmptyOrNullString()))
                                .body("address.street", not(isEmptyOrNullString()))
                                .body("address.number", greaterThan(0))
                                .body("address.zipcode", not(isEmptyOrNullString()))
                                .body("address.geolocation.lat", not(isEmptyOrNullString()))
                                .body("address.geolocation.long", not(isEmptyOrNullString()))
                                .body("__v", is(0))
                )
        );
    }



}
