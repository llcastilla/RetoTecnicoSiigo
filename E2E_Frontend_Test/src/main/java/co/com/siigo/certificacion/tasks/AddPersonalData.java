package co.com.siigo.certificacion.tasks;

import co.com.siigo.certificacion.interactions.StopWatch;
import co.com.siigo.certificacion.models.PersonalData;
import co.com.siigo.certificacion.userinterfaces.GenericsPage;
import co.com.siigo.certificacion.utils.DateTimeFormat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static co.com.siigo.certificacion.userinterfaces.login.PersonalDataPage.*;

public class AddPersonalData implements Task {

    private final PersonalData personalData;

    public AddPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Bajar el zoom al 50%
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");
        actor.attemptsTo(

                Click.on(LBX_DOCUMENT_TYPE),
                Click.on(SEL_DOCUMENT_TYPE),
                Check.whether(personalData.getDocumentNumber().equals("0"))
                        .andIfSo(Enter.theValue(DateTimeFormat.DesiredDate()).into(TXT_DOCUMENT))
                        .otherwise(Enter.theValue(personalData.getDocumentNumber()).into(TXT_DOCUMENT)),
                Enter.theValue(personalData.getEmail()).into(TXT_EMAIL),
                StopWatch.inSeconds(8),

                Click.on(GenericsPage.BTN_CONTINUE),
                StopWatch.inSeconds(8)


                );
    }

    public static AddPersonalData enTheForm(PersonalData personalData) {
        return Tasks.instrumented(AddPersonalData.class, personalData);

    }
}
