package co.com.siigo.certificacion.userinterfaces.login;

import net.serenitybdd.screenplay.targets.Target;


public class ContactDataPage {


    public static final Target RADIO_TYPE_ACCOUNT = Target.the("RADIO BUTTON TIPO DE CUENTA")
            .locatedBy("//input[@type='radio' and @name='Tipo_producto' and @value='0']");
    public static final Target TXT_PRODUCTNUMBER = Target.the("Campo para agregar Número de producto / Product number")
            .locatedBy("//input[@id='numberinput-47c6cb9388-widget']");
    public static final Target TXT_HOLDER_NAME = Target.the("Campo Nombre completo del titular principal del producto / Full name of main holder of the product")
            .locatedBy("//input[@name='nombre_titular']");
    public static final Target SELECT_TYPE_ID = Target.the("RADIO BUTTON TIPO DE CUENTA")
            .locatedBy("//select[@name='tipo_documento']");
    public static final Target IMPUT_TYPE_ID = Target.the("RADIO BUTTON TIPO DE ID")
            .locatedBy("//option[@value='CC-Cedula de Ciudadania']");
    public static final Target TXT_NUM_ID = Target.the("Campo numero id")
            .locatedBy("//input[@name='numero_documento']");
    public static final Target RADIO_TYPE_ACCOUNT_2 = Target.the("Campo numero id")
            .locatedBy("//input[@type='radio' and @name='tipo_cuenta' and @value='0']");
    public static final Target SELECT_TYPE_OF_CHANGE = Target.the("Tipo de modificación / Type of change")
            .locatedBy("//select[@name='tipo_moficacion']");
    public static final Target CLICK_OPTION = Target.the("VALOR A SELECCIONAR INCLUIR / ADD")
            .locatedBy("//option[@value='Incluir / Add']");
    public static final Target SEL_TYPE_ID = Target.the("Tipo de documento")
            .locatedBy("//select[@name='tipo_id' and @data-testid='select']");
    public static final Target CLICK_TYPE_ID = Target.the("Tipo de documento")
            .locatedBy("(//option[@value='CC-Cedula de Ciudadania'])[2]");
    public static final Target TX_NUM_ID = Target.the("numero de doc")
            .locatedBy("//input[@name='numero_id']");
    public static final Target TX_FULL_NAME = Target.the("NOMBRE COMPLETO")
            .locatedBy("//input[@name='nombre_completo']");

    public static final Target CLICK_SIGNATURE_TYPE = Target.the("Tipo de FIRMA")
            .locatedBy("//select[@name='tipo_firma' and @data-testid='select']");
    public static final Target SEL_SIGNATURE_TYPE = Target.the("Tipo de documento")
            .locatedBy("//option[@value='Cotitular (PN)']");
    public static final Target TX2_FULL_NAME = Target.the("NOMBRE COMPLETO")
            .locatedBy("//input[@name='nombre1']");
}
