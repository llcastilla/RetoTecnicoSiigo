package co.com.siigo.certificacion.userinterfaces.crearCliente;

import co.com.siigo.certificacion.utils.ByJavascript;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.*;


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

    public static final Target INPUT_NOMBRE_COMERCIAL = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-textfield-web", 4, "input.mdc-text-field__input"));


    public static Target INPUT_AUTOCOMPLETE_CITY = Target.the("Input autocomplete city dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-autocomplete-web", 0, "#inputAutocompletecity"));

    public static final Target INPUT_DIRECCION = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-textfield-web", 5, "input.mdc-text-field__input"));


    public static final Target INPUT_INDICATIVO = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-phone-web", 0, "input,mdc-text-field__input siigo-phone"));

    public static final Target INPUT_TELEFONO = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-phone-web", 0, "input,mdc-text-field__input siigo-phone", 1));

    public static final Target INPUT_EXTENSION = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-phone-web", 0, "input,mdc-text-field__input siigo-phone", 2));

    public static final Target INPUT_REGIMEN = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-dropdownlist-web", 3, "div,mdc-select__anchor mdc-ripple-upgraded",2));

    public static final Target INPUT_REGIMEN_SEL = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-dropdownlist-web", 3, "li,mdc-list-item", 2));

    public static final Target INPUT_REGIMEN_INDICATIVO = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-textfield-web", 9, "input,mdc-text-field__input"));
    public static final Target INPUT_REGIMEN_TELEFONO = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-textfield-web", 10, "input,mdc-text-field__input"));

    public static final Target INPUT_CODIGO_POSTAL = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-textfield-web", 11, "input,mdc-text-field__input"));

    public static final Target H3_CONTACTO = Target.the("Input específico dentro del Shadow DOM")
            .located(By.xpath("//h3[contains(.,'Contactos')]"));

    public static final Target INPUT_NOMBRE = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-textfield-web", 12, "input,mdc-text-field__input"));

    public static final Target INPUT_APELLIDO = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-textfield-web", 13, "input,mdc-text-field__input"));

    public static final Target INPUT_CORREO = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-emailinput-web", 0, "#emailinput"));

    public static final Target INPUT_CARGO = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-textfield-web", 14, "input,mdc-text-field__input"));

    public static final Target INPUT_INDICATIVO_CONTACTO = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-textfield-web", 15, "input,mdc-text-field__input"));

    public static final Target INPUT_TELEFONO_CONTACTO = Target.the("Input específico dentro del Shadow DOM")
            .located(ByJavascript.shadowElementByIndex("siigo-textfield-web", 16, "input,mdc-text-field__input"));

}

