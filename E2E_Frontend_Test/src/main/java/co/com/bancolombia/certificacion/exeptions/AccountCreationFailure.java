package co.com.bancolombia.certificacion.exeptions;

public class AccountCreationFailure extends AssertionError {
    public AccountCreationFailure(String mensaje) {
        super(mensaje);
    }
    public AccountCreationFailure(String message, Throwable cause) {
        super(message, cause);
    }
}
