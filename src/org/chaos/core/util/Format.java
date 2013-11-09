package org.chaos.core.util;

import java.text.DecimalFormat;

/**
 * @author chaos_
 * @since 1.0 <1:19 AM - 08/11/13>
 */
public class Format {

    private static String[] SUFFIX = new String[]{"","k", "m", "b", "t"};
    private static int MAX_LENGTH = 6;

    /**
     * @author "http://stackoverflow.com/questions/4753251/"
     */
    public static String toK(double number) {
        String r = new DecimalFormat("##0E0").format(number);
        r = r.replaceAll("E[0-9]", SUFFIX[Character.getNumericValue(r.charAt(r.length()-1))/3]);
        return r.length()>MAX_LENGTH ?  r.replaceAll("\\.[0-9]+", "") : r;
    }

    /**
     * @author Coma
     */
    public static String time(long time) {
        final StringBuilder t = new StringBuilder();
        final long total_secs = time / 1000;
        final long total_mins = total_secs / 60;
        final long total_hrs = total_mins / 60;
        final long total_days = total_hrs / 24;
        final int secs = (int) total_secs % 60;
        final int mins = (int) total_mins % 60;
        final int hrs = (int) total_hrs % 24;
        final int days = (int) total_days;
        if (days > 0) {
            if (days < 10) {
                t.append("0");
            }
            t.append(days);
            t.append(":");
        }
        if (hrs < 10) {
            t.append("0");
        }
        t.append(hrs);
        t.append(":");
        if (mins < 10) {
            t.append("0");
        }
        t.append(mins);
        t.append(":");
        if (secs < 10) {
            t.append("0");
        }
        t.append(secs);
        return t.toString();
    }

}
