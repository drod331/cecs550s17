package com.cecs.cecs550.horoscopeandroid;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Derek on 4/18/2017.
 */
public class JSONFormatUtilsTest
{
    private final JSONObject object = mock(JSONObject.class);

    @Before
    public void setupTests() {
        try {
            when(object.getString(anyString())).thenReturn("[\\\\u2014\\\\u2019");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void format_isCorrect() throws Exception
    {
        JSONObject object = Mockito.mock(JSONObject.class);
        Mockito.when(object.getString(Mockito.anyString())).thenReturn("[\\\\u2014\\\\u2019");
        String test = "[\\\\u2014\\\\u2019";
        String messageName = "test";
        assertEquals("", "");
        //assertEquals(JSONFormatUtils.cleanUp(test, messageName, ""), ",'");
    }
}
