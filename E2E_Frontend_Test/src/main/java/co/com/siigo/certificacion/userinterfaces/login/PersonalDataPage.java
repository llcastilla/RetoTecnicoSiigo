package co.com.siigo.certificacion.userinterfaces.login;

import static net.serenitybdd.core.annotations.findby.By.id;

import net.serenitybdd.screenplay.targets.Target;

public class PersonalDataPage {

    public static final Target LBX_DOCUMENT_TYPE = Target.the("Lista tipo de documento")
            .locatedBy("//input[@id='idType']");
    public static final Target SEL_DOCUMENT_TYPE = Target.the("Lista tipo de documento")
            .locatedBy("//li[@class='bc-input-select-item' and .//span[text()='Cédula de Ciudadanía']]");
    public static final Target TXT_DOCUMENT = Target.the("Campo número de documento")
            .located(id("Número de documento"));
    public static final Target TXT_EMAIL = Target.the("Campo número de documento")
            .located(id("email"));

    private PersonalDataPage() {

    }
}
