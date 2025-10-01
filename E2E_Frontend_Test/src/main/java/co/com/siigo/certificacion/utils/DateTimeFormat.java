package co.com.siigo.certificacion.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormat {
    private DateTimeFormat(){}
    public static String DesiredDate () {
        LocalDateTime dateCurrentTime = LocalDateTime.now();


        DateTimeFormatter formatDesired = DateTimeFormatter.ofPattern("yyMMddHHmmss");

        return dateCurrentTime.format(formatDesired);


    }
}

