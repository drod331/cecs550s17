package core;

/**
 * Created by Derek on 4/13/2017.
 */
public enum SunSign
{
    CAPRICORN("capricorn"), AQUARIUS("aquarius"), PISCES("pisces"), ARIES("aries"), TAURUS("taurus"), GEMINI("gemini"),
    CANCER("cancer"), LEO("leo"), VIRGO("virgo"), LIBRA("libra"), SCORPIO("scorpio"), SAGITTARIUS("sagittarius");

    private final String friendlyName;

    @Override
    public String toString()
    {
        return friendlyName;
    }

    SunSign(String value)
    {
        friendlyName = value;
    }
}
