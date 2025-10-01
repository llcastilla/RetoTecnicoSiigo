package co.com.siigo.certificacion.stepdefinitions.crearCliente;

import co.com.siigo.certificacion.models.Customer;
import co.com.siigo.certificacion.questions.AlertaGuardado;
import co.com.siigo.certificacion.tasks.CredencialesCorreo;
import co.com.siigo.certificacion.tasks.NavegarAClientesTerceros;
import co.com.siigo.certificacion.tasks.RegistrarCliente;
import co.com.siigo.certificacion.userinterfaces.MainPagePage;
import co.com.siigo.certificacion.utils.dataPruebas;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

import static co.com.siigo.certificacion.utils.WordsToRemember.CUSTOMER_DATA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;


public class CrearClienteStep {

    @After
    public static void CloseDriver() {
        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
    }

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        Actor actor = OnStage.theActorCalled("actor");
        actor.wasAbleTo(Open.browserOn().the(MainPagePage.class));
    }

    @Given("el usuario se loguea {}")
    public void elUsuarioSeLogueaDataLogin(String prolife) {
        theActorInTheSpotlight().remember(CUSTOMER_DATA, dataPruebas.getCustomerDataWith(prolife));
    }
    @When("navega a la sección Clientes Terceros")
    public void navegaALaSecciónClientesTerceros() {
        Customer customer = theActorInTheSpotlight().recall(CUSTOMER_DATA);

        theActorInTheSpotlight().attemptsTo(
                CredencialesCorreo.delTramite(customer.getLoginExitoso()),
                NavegarAClientesTerceros.delFormulariofront()

        );
    }
    @And("ingresa los datos del cliente tercero desde el archivo")
    public void ingresaLosDatosDelClienteTerceroDesdeElArchivoDataClienteJson() {
        Customer customer = theActorInTheSpotlight().recall(CUSTOMER_DATA);
        theActorInTheSpotlight().attemptsTo(
                RegistrarCliente.registrarCliente(customer.getDataCliente(),customer.getContacto())


        );
    }
    @Then("el sistema muestra un mensaje de confirmación Cliente tercero creado exitosamente")
    public void elSistemaMuestraUnMensajeDeConfirmaciónClienteTerceroCreadoExitosamente() {
        theActorInTheSpotlight().should(
                seeThat("El mensaje de confirmación",
                        AlertaGuardado.es(),
                        equalTo("Tercero guardado exitosamente"))
        );
    }

}
