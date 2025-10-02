package co.com.siigo.certificacion.models.utils;

public class Constants {

    public static final String ENDPOINT_PRODUCTO_GET = "https://fakestoreapi.com/products";

    public static final String ENDPOINT_PRODUCTO_PATCH = "https://fakestoreapi.com/products/1";

    public static final String ENDPOINT_PRODUCTO_DEL = "https://fakestoreapi.com/products/1";


    public static final String EMPTY = "";
    public static final String AUTHORIZATION = "Authorization";
    public static final String COOKIE = System.getenv("COOKIE");


    public static final String QUERYPRODUCTO = "{\"title\": \"New Product\", \"price\": 29.99}";


    public static final String QUERYCREATEUSER = "{\n" +
            "  \"fullName\": \"" + System.getenv("NAME") + "\",\n" +
            "  \"username\": \"" + System.getenv("USUARIO") + "\",\n" +
            "  \"password\": \"Fbey6d9ti_*1190\",\n" +
            "  \"email\": \"" + System.getenv("EMAIL") + "\",\n" +
            "  \"role\": \"operador\"\n" +
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
