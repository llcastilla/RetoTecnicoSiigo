package co.com.siigo.certificacion.exeptions;

public class CouldNotReadTheJsonExeption extends Exception{

    public CouldNotReadTheJsonExeption(String mensaje, Throwable e){
        super(mensaje, e);
    }
}
