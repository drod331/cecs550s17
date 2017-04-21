package util;

import java.util.Locale;

import java.util.Locale;

/**
 * Created by Derek on 4/17/2017.
 */
public class StringUtils
{
    public static String capitalize(String string)
    {
        return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
    }

    public static String capitalize(String string, Locale locale)
    {
        return string.substring(0,1).toUpperCase(locale) + string.substring(1).toLowerCase(locale);
    }
}
