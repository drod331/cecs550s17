package com.cecs.cecs550.horoscopeandroid;


import org.junit.Test;
import util.StringUtils;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by Derek on 4/18/2017.
 */
public class StringUtilsTest
{
    @Test
    public void capitalize_isCorrect() throws Exception
    {
        String test = "mark";
        assertEquals(StringUtils.capitalize(test), "Mark");
    }

    /*@Test
    public void capitalize_isEmpty() throws Exception
    {
        String test = "";
        assertEquals(StringUtils.capitalize(test), "");
    }*/

    @Test
    public void capitalizeLocale_isCorrect() throws Exception
    {
        String test = "mark";
        assertEquals(StringUtils.capitalize(test, Locale.ENGLISH), "Mark");
    }

    /*@Test
    public void capitalizeLocale_isEmpty() throws Exception
    {
        String test = "";
        assertEquals(StringUtils.capitalize(test, Locale.ENGLISH), "");
    }*/
}
