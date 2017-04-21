package com.cecs.cecs550.horoscopeandroid;

import core.SunSign;
import core.SunSignHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Derek on 4/18/2017.
 */
public class SunSignHelperTest
{
    @Test
    public void determineSign_isCorrect() throws Exception
    {
        assertEquals(SunSignHelper.determineSunSign("January", 4), "Your sign is: Capricorn");
        assertEquals(SunSignHelper.determineSunSign("January", 21), "Your sign is: Aquarius");
        assertEquals(SunSignHelper.determineSunSign("February", 4), "Your sign is: Aquarius");
        assertEquals(SunSignHelper.determineSunSign("February", 23), "Your sign is: Pisces");
        assertEquals(SunSignHelper.determineSunSign("March", 4), "Your sign is: Pisces");
        assertEquals(SunSignHelper.determineSunSign("March", 31), "Your sign is: Aries");
        assertEquals(SunSignHelper.determineSunSign("April", 4), "Your sign is: Aries");
        assertEquals(SunSignHelper.determineSunSign("April", 31), "Your sign is: Taurus");
        assertEquals(SunSignHelper.determineSunSign("May", 4), "Your sign is: Taurus");
        assertEquals(SunSignHelper.determineSunSign("May", 31), "Your sign is: Gemini");
        assertEquals(SunSignHelper.determineSunSign("June", 4), "Your sign is: Gemini");
        assertEquals(SunSignHelper.determineSunSign("June", 31), "Your sign is: Cancer");
        assertEquals(SunSignHelper.determineSunSign("July", 4), "Your sign is: Cancer");
        assertEquals(SunSignHelper.determineSunSign("July", 31), "Your sign is: Leo");
        assertEquals(SunSignHelper.determineSunSign("August", 4), "Your sign is: Leo");
        assertEquals(SunSignHelper.determineSunSign("August", 31), "Your sign is: Virgo");
        assertEquals(SunSignHelper.determineSunSign("September", 4), "Your sign is: Virgo");
        assertEquals(SunSignHelper.determineSunSign("September", 31), "Your sign is: Libra");
    }

    @Test
    public void getSunSignCharacteristics_isCorrect() throws Exception
    {
        assertEquals(SunSignHelper.getSunSignCharacteristics(SunSign.AQUARIUS), "Progressive, original, independent, humanitarian\n"+
                "Runs from emotional expression, temperamental\n"+
                "Fun with friends, helping others, intellectual conversation, a good listener\n"+
                "Limitations, broken promises, being lonely, people who disagree with them");
    }
}
