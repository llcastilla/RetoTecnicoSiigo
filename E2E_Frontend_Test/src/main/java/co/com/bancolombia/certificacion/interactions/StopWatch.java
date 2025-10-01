package co.com.bancolombia.certificacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.SilentPerformable;

import java.util.concurrent.TimeUnit;

public class StopWatch extends SilentPerformable {
    private final long tiempo;

    public StopWatch(long tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        org.apache.commons.lang3.time.StopWatch stopWatch = new org.apache.commons.lang3.time.StopWatch();
        long timer;
        stopWatch.start();
        do {
            timer = stopWatch.getTime(TimeUnit.SECONDS);
            if(timer>tiempo){
                stopWatch.stop();
                break;
            }
        }while (true);
    }
    public static SilentPerformable inSeconds(long seconds){
        return Tasks.instrumented(StopWatch.class, seconds);
    }
}
