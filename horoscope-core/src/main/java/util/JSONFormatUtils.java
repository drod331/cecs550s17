package util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Derek on 4/17/2017.
 */

//Provides utility functions for cleaning up JSON format messages.
public class JSONFormatUtils
{
    //Cleans up JSON messages by replacing unicode codes with the proper character representation.  Also is capable of deleting extraneous footer information.
    //@TODO Make greater generalized version
    public static String cleanUp(String jsonMessage, String messageName, String footerText){
        try{
            JSONObject obj = null;
            try {
                obj = new JSONObject(jsonMessage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String string = obj.getString(messageName);
            string = string.replace("['", "");
            string = string.replaceAll("\\\\u2014", ",");
            string = string.replaceAll("\\\\u2019", "'");
            string = string.replaceAll(footerText, "");
            return string;
        }
        catch(JSONException e){
            return null;
        }
    }
}
