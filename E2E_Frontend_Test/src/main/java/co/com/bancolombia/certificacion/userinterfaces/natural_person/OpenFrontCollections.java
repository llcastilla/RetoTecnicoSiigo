package co.com.bancolombia.certificacion.userinterfaces.natural_person;

import net.serenitybdd.screenplay.targets.Target;

public class OpenFrontCollections {
    public static final Target SELECT_PROCEDURE_BUTTON  = Target.the("Checbox para seleccionar tramite")
            .locatedBy("//p[contains(text(),'{0}')]/ancestor::div[contains(@class,'bg-clip-border')]//img[@alt='Arrow']");
    private OpenFrontCollections(){

    }
}
