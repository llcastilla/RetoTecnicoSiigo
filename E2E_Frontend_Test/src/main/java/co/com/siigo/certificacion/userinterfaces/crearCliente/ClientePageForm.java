package co.com.siigo.certificacion.userinterfaces.crearCliente;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;


public class ClientePageForm {
    public static final Target CHECKBOX_IS_CLIENT = Target.the("Checkbox IsClient")
            .located(By.cssSelector("input[name='isClient']"));

    public static final Target LISTADO_TIPO = Target.the("Listado Tipo")
            .located(ByShadow.cssSelector(
                    ".mdc-select__anchor", // Selector dentro del shadowRoot para abrir el dropdown
                    "siigo-dropdownlist-web[coloredfirstel='12;']" // Shadow host
            ));

    public static final Target OPCION_ES_PERSONA = Target.the("Opción 'Es persona'")
            .located(ByShadow.cssSelector(
                    "li.mdc-list-item[data-value*='\"Es persona\"']", // Selector dentro del shadowRoot
                    "siigo-dropdownlist-web[coloredfirstel='12;']" // Shadow host
            ));
    public static final Target INPUT_IDENTIFICACION = Target.the("Campo de identificación")
            .located(ByShadow.cssSelector(
                    "input.mdc-text-field__input.input-identification",
                    "siigo-identification-input-web"
            ));

    public static final Target AUTOCOMPLETAR_DATOS = Target.the("Botón Autocompletar datos")
            .located(By.xpath("//span[@class='autocomplete-link' and normalize-space(text())='Autocompletar datos']"));


    public static final Target INPUT_SUCURSAL = Target.the("Campo numérico")
            .located(ByShadow.cssSelector(
                    "input.mdc-text-field__input",
                    "siigo-textfield-web"
            ));
}
