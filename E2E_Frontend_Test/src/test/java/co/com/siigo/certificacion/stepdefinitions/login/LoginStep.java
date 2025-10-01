package co.com.siigo.certificacion.stepdefinitions.login;

import co.com.siigo.certificacion.models.Customer;
import co.com.siigo.certificacion.tasks.*;
import co.com.siigo.certificacion.userinterfaces.MainPagePage;
import co.com.siigo.certificacion.utils.dataPruebas;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import static co.com.siigo.certificacion.userinterfaces.ValidationMessagesPage.TEXTO_BIENVENIDA;
import static co.com.siigo.certificacion.userinterfaces.ValidationMessagesPage.TEXTO_CREDENCIALES_INCORRECTAS;
import static co.com.siigo.certificacion.utils.WordsToRemember.CUSTOMER_DATA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LoginStep {

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

    @Given("el usuario abre la página de login {}")
    public void elUsuarioAbreLaPáginaDeLoginData(String prolife) {
        theActorInTheSpotlight().remember(CUSTOMER_DATA, dataPruebas.getCustomerDataWith(prolife));

    }

    @When("ingresa credenciales válidas")
    public void ingresaCredencialesVálidas() {
        Customer customer = theActorInTheSpotlight().recall(CUSTOMER_DATA);

        theActorInTheSpotlight().attemptsTo(
                CredencialesCorreo.delTramite(customer.getLoginExitoso())
        );
    }


    @Then("el sistema redirige al dashboard principal")
    public void elSistemaRedirigeAlDashboardPrincipal() throws InterruptedException {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TEXTO_BIENVENIDA, isVisible()).forNoMoreThan(10).seconds()
        );

        String texto = TEXTO_BIENVENIDA.resolveFor(theActorInTheSpotlight()).getText();

// Tomar solo la primera línea limpia de espacios extra
        String primerLinea = texto.split("\\r?\\n")[0].trim();

        assertThat(primerLinea).contains("Te damos la bienvenida, ¿Qué deseas hacer?");
    }


    @When("ingresa credenciales inválidas")
    public void ingresaCredencialesInválidas() {
        Customer customer = theActorInTheSpotlight().recall(CUSTOMER_DATA);

        theActorInTheSpotlight().attemptsTo(
                CredencialesCorreoInvalido.delTramite(customer.getLoginFallido())
        );
    }

    @Then("el sistema muestra el mensaje de error Usuario o contraseña incorrectos")
    public void elSistemaMuestraElMensajeDeErrorUsuarioOContraseñaIncorrectos() {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TEXTO_CREDENCIALES_INCORRECTAS, isVisible()).forNoMoreThan(10).seconds()
        );

        String texto = TEXTO_CREDENCIALES_INCORRECTAS.resolveFor(theActorInTheSpotlight()).getText();

        // Tomar solo la primera línea limpia de espacios extra
        String primerLinea = texto.split("\\r?\\n")[0].trim();

        assertThat(primerLinea).contains("Usuario o contraseña inválidos");
    }


}
