package Lottory_toys;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateTime {

    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z"); 
    static Date date = new Date(System.currentTimeMillis()); 

    public static String getDateTime() {
        return formatter.format(date);
    }

}
