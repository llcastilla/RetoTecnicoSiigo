package co.com.siigo.certificacion.models.utils;

public class Constants {
    public static final String ENDPOINT_TOKEN_AUTH = "https://api.tarjeta-debito-pr-qa.apps.ambientesbc.com/tardeb/api/v1/auth/login_guest";
    public static final String ENDPOINT_TOKEN_ADMIN = "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/auth/login";
    public static final String ENDPOINT_USER = "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/users?page=1&limit=100";
    public static final String ENDPOINT_ROLES = "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/roles";
    public static final String ENDPOINT_ROLES_ID = "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/users/bdd3f06c-55e5-44de-bc2c-702869a41296";
    public static final String ENDPOINT_CREATE_USER = "https://api.tarjeta-debito-pr-qa.apps.ambientesbc.com/tardeb/api/v1/users";
    public static final String ENDPOINT_PRODUCTO = "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/products/one/21cb2c64-082f-4335-b80e-3c75d8f693a5";
    public static final String ENDPOINT_PRODUCTO_ACTIVO = "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/products/active";
    public static final String ENDPOINT_CREAR_PRODUCTO = "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/products";
    public static final String ENDPOINT_PROCEDURES= "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/procedures/find_all_procedures_without_login?page=1&limit=100";
    public static final String ENDPOINT_PROCEDURES_ID= "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/procedures/fe5f7d81-3c97-4b71-a9e8-e822d0cf3243";
    public static final String ENDPOINT_FORMTATO= "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/formats?page=1&limit=100";
    public static final String ENDPOINT_FIELDS= "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/fields/8f1d6203-60a7-4848-862d-b44b4d055440";

    public static final String ENDPOINT_SMS = "https://api.frc-fe-qa.apps.ambientesbc.com/frc/api/v1/sms/send-code";

    public static final String ENDPOINT_CONSULTARCLIENTES_NOT_EXIST = "https://negocios-inversion-int-qa.apps.ambientesbc.com/prac-perf-ries-analis-conv/ms-gestioninformacioncliente/api/getCustomerInformation/TIPDOC_FS001/455566677";



    public static final String EMPTY = "";
    public static final String AUTHORIZATION = "Authorization";
    public static final String COOKIE = System.getenv("COOKIE");


    public static final String QUERYPRODUCTO ="{\n" +
            "  \"description\": \""+System.getenv("NOMBREPRODUCTO")+"\",\n" +
            "  \"isActive\": false  \n" +
            "}";
    public static final String QUERYPRODUCTOERROR = "{\n" +
            "  \"description\": \"laborAe esse reprehendddrit non qui\",\n" +
            "  \"isActive\": false  \n" +
            "}";

    public static final String QUERYTD ="{\n" +
            "    \"skip\": 0,\n" +
            "    \"take\": 5,\n" +
            "    \"state\": \"Todos\"\n" +
            "}";


    public static final String QUERYTDERROR ="{\n" +
            "    \"skip\": ,\n" +
            "    \"take\": ,\n" +
            "    \"state\": \n" +
            "}";

    public static final String QUERYSMS ="{\n" +
            "  \"email\": \"lelcasti@bancolombia.com.co\",\n" +
            "  \"phone\": \"+573246645165\"\n" +
            "}";


    public static final String QUERYSMSERROR ="{\n" +
            "  \"email\": \"\",\n" +
            "  \"phone\": \"\"\n" +
            "}";

    public static final String QUERYID = "{\n" +
            "    \"name\": \"PRUEBA AUTOMATIZADA \"\n" +
            "}";


    public static final String QUERYIDERROR = "{\n" +
            "    \"name\": \"\"\n" +
            "}";

    public static final String QUERYUPDATEID = "{\n" +
            "    \"id\": \""+ System.getenv("IDENTIUPDATE")+"\",\n" +
            "    \"name\": \"PRUEBA AUTOMATIZADA 2\"\n" +
            "}";
    public static final String QUERYUPDATEIDERROR = "{\n" +
            "    \"id\": \"\",\n" +
            "    \"name\": \"\"\n" +
            "}";

    public static final String QUERYLOGIN = "{\n" +
            "  \"username\": \"usuarioadmin@bancolombia.com.co\",\n" +
            "  \"password\": \"Admin123456*\"\n" +
            "}";

    public static final String QUERYUPDATESEGMENTOERROR = "{\n" +
            "    \"id\": \"3e6ASc6952-9e84-4815-95ASca-fca0c91be86c\",\n" +
            "    \"name\": \"PRUEBA AUTOMATIZADA ASDA\",\n" +
            "    \"code\": \"1500\"\n" +
            "}";

    public static final String QUERYUPDATESEGMENTO = "{\n" +
            "    \"id\": \""+System.getenv("UPDATESEGMENTO")+"\",\n" +
            "    \"name\": \"PRUEBA AUTOMATIZADA ASDA\",\n" +
            "    \"code\": \"1500\"\n" +
            "}";

    public static final String QUERYCREATSEGMENTO = "{\n" +
            "    \"name\": \"PRUEBA AUTOMATIZADA \",\n" +
            "    \"code\": \"1500\"\n" +
            "}";

    public static final String QUERYCREATSEGMENTOERROR = "{\n" +
            "    \"name\": \"\",\n" +
            "    \"code\": \"\"\n" +
            "}";
    public static final String QUERYCREATEUSER = "{\n" +
            "  \"fullName\": \"" + System.getenv("NAME") + "\",\n" +
            "  \"username\": \"" + System.getenv("USUARIO") + "\",\n" +
            "  \"password\": \"Fbey6d9ti_*1190\",\n" +
            "  \"email\": \"" + System.getenv("EMAIL") + "\",\n" +
            "  \"role\": \"operador\"\n" +
            "}";

    public static final String QUERYLOGINERROR = "{\n" +
            "  \"username\": \"accesos@baASncolombia.com\",\n" +
            "  \"password\": \"0qkEDRSdX6RhPjy\"\n" +
            "}";

    public static final String SINDATOS = "";

    public static final String TOKEN = System.getenv("TOKEN");
    public static final String GRANT_TYPE = "grant_type";
    public static final String GRANT_TYPE_VALUE = "client_credentials";
    public static final Integer ESTADO_SERVICIO_OK = 200;
    public static final Integer ESTADO_OK = 201;
    public static final Integer ESTADO_SERVICIO_401 = 401;
    public static final Integer ESTADO_SERVICIO_400 = 400;

    public static final Integer ESTADO_SERVICIO_500 = 500;
    public static final Integer ESTADO_SERVICIO_422 = 422;

    public static final Integer ESTADO_SERVICIO_EXISTE = 409;
    public static final Integer ESTADO_SERVICIO_404 = 404;





}
