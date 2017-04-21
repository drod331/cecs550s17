package net;

import core.SunSign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Derek on 4/21/2017.
 */
public class HoroscopeSource extends DataSource
{
    private final String urlStr = "http://sandipbgt.com/theastrologer/api/horoscope/";
    public String getHoroscopeFor(SunSign sunSign)
    {
        URL url = null;
        StringBuilder sb = new StringBuilder();
        try {
            url = new URL(urlStr + sunSign.toString() + "/today/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() != 200) {
                throw new IOException(conn.getResponseMessage());
            }
            // Buffer the result into a string
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
