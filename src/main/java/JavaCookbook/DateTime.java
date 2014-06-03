package JavaCookbook;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Michael.Shreiber on 2/12/14.
 */
public class DateTime {

    public static void main(String[] args) {

        //Now
        System.out.println(Calendar.getInstance().getTime());

        //Local formats
        Date today = new Date();
        DateFormat df = DateFormat.getInstance();
        System.out.println(df.format(today));
        DateFormat df_fr = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRENCH);
        System.out.println(df_fr.format(today));
        DateFormat df_us = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        System.out.println(df_us.format(today));


    }
}
