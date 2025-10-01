package co.com.bancolombia.certificacion.gestioninformacioncliente.models;

public class Customer {
    private String identificationType;

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    private String identification;
}
