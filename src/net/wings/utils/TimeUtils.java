package net.wings.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wing on 2017/5/16.
 */
public class TimeUtils {
    public static String getDateString() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(date);
    }

}
