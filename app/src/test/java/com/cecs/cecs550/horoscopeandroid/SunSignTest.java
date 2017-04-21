package com.cecs.cecs550.horoscopeandroid;

import core.SunSign;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Derek on 4/18/2017.
 */
public class SunSignTest
{
    @Test
    public void constructor_isCorrect() throws Exception
    {
        assertEquals(SunSign.AQUARIUS.toString(), "aquarius");
    }
}
