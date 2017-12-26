/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhcl_email;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author vikra
 */
public class DateAndTime {
     public static final String DATE_FORMAT_NOW = "MMM-dd-yyyy";
    public static String dt;
    //get the date and time now
    public static String DateTime()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }
}
