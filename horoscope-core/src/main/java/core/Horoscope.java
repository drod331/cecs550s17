package core;

/**
 * Created by Derek on 4/13/2017.
 */
public class Horoscope
{
    Horoscope(String text, SunSign sunSign)
    {
        this.text = text;
        this.sunSign = sunSign;
    }

    private SunSign sunSign;
    private String text;

    public SunSign getSunSign() {
        return sunSign;
    }

    public void setSunSign(SunSign sunSign) {
        this.sunSign = sunSign;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Horoscope{" +
                "sunSign=" + sunSign +
                ", text='" + text + '\'' +
                '}';
    }
}


