package co.com.siigo.certificacion.tasks;

import co.com.siigo.certificacion.interactions.StopWatch;
import co.com.siigo.certificacion.models.ContactData;
import co.com.siigo.certificacion.userinterfaces.GenericsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static co.com.siigo.certificacion.userinterfaces.login.ContactDataPage.*;


public class AddContactData implements Task {


    private final ContactData contactData;

    public AddContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Bajar el zoom al 50%
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");

        actor.attemptsTo(
                Scroll.to(GenericsPage.BTN_COMPLETE),
                Click.on(GenericsPage.BTN_COMPLETE),

                StopWatch.inSeconds(15),

                Scroll.to(RADIO_TYPE_ACCOUNT),
                Click.on(RADIO_TYPE_ACCOUNT),

                Scroll.to(TXT_PRODUCTNUMBER),
                Enter.theValue(contactData.getProductNumber()).into(TXT_PRODUCTNUMBER),

                Scroll.to(TXT_HOLDER_NAME),
                Enter.theValue(contactData.getHolderName()).into(TXT_HOLDER_NAME),

                Scroll.to(SELECT_TYPE_ID),
                Click.on(SELECT_TYPE_ID),

                Scroll.to(IMPUT_TYPE_ID),
                Click.on(IMPUT_TYPE_ID),

                Scroll.to(TXT_NUM_ID),
                Enter.theValue(contactData.getNumId()).into(TXT_NUM_ID),

                Scroll.to(RADIO_TYPE_ACCOUNT_2),
                Click.on(RADIO_TYPE_ACCOUNT_2),

                Scroll.to(SELECT_TYPE_OF_CHANGE),
                Click.on(SELECT_TYPE_OF_CHANGE),

                Scroll.to(CLICK_OPTION),
                Click.on(CLICK_OPTION),

                Scroll.to(SEL_TYPE_ID),
                Click.on(SEL_TYPE_ID),

                Scroll.to(CLICK_TYPE_ID),
                Click.on(CLICK_TYPE_ID),

                Scroll.to(TX_NUM_ID),
                Enter.theValue(contactData.getNumId()).into(TX_NUM_ID),

                Scroll.to(TX_FULL_NAME),
                Enter.theValue(contactData.getHolderName()).into(TX_FULL_NAME),

                Scroll.to(CLICK_SIGNATURE_TYPE),
                Click.on(CLICK_SIGNATURE_TYPE),

                Scroll.to(SEL_SIGNATURE_TYPE),
                Click.on(SEL_SIGNATURE_TYPE),

                Scroll.to(TX2_FULL_NAME),
                Enter.theValue(contactData.getHolderName()).into(TX2_FULL_NAME),

                StopWatch.inSeconds(8),

                Scroll.to(GenericsPage.BTN_SEND),
                Click.on(GenericsPage.BTN_SEND),
                StopWatch.inSeconds(6),

                Scroll.to(GenericsPage.BTN_ACCEPT),
                Click.on(GenericsPage.BTN_ACCEPT)


        );

    }

    public static AddContactData enElFormulario(ContactData contactData) {
        return Tasks.instrumented(AddContactData.class, contactData);
    }
}
