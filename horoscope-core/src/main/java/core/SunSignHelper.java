package core;

/**
 * Created by Derek on 4/17/2017.
 */
public class SunSignHelper 
{
    public static String determineSunSign(String month, int day)
    {
        String string;
        switch(month){
            case "January":
                if(day < 20)
                    string = "Your sign is: Capricorn";
                else
                    string = "Your sign is: Aquarius";
                break;
            case "February":
                if(day < 19)
                    string = "Your sign is: Aquarius";
                else
                    string = "Your sign is: Pisces";
                break;
            case "March":
                if(day < 21)
                    string = "Your sign is: Pisces";
                else
                    string = "Your sign is: Aries";
                break;
            case "April":
                if(day < 20)
                    string = "Your sign is: Aries";
                else
                    string = "Your sign is: Taurus";
                break;
            case "May":
                if(day < 21)
                    string = "Your sign is: Taurus";
                else
                    string = "Your sign is: Gemini";
                break;
            case "June":
                if(day < 21)
                    string = "Your sign is: Gemini";
                else
                    string = "Your sign is: Cancer";
                break;
            case "July":
                if(day < 23)
                    string = "Your sign is: Cancer";
                else
                    string = "Your sign is: Leo";
                break;
            case "August":
                if(day < 23)
                    string = "Your sign is: Leo";
                else
                    string = "Your sign is: Virgo";
                break;
            case "September":
                if(day < 23)
                    string = "Your sign is: Virgo";
                else
                    string = "Your sign is: Libra";
                break;
            case "October":
                if(day < 23)
                    string = "Your sign is: Libra";
                else
                    string = "Your sign is: Scorpio";
                break;
            case "November":
                if(day < 22)
                    string = "Your sign is: Scorpio";
                else
                    string = "Your sign is: Sagittarius";
                break;
            case "December":
                if(day < 22)
                    string = "Your sign is: Sagittarius";
                else
                    string = "Your sign is: Capricorn";
                break;
            default:
                string = "";
                break;
        }
        return string;
    }

    public static String getSunSignCharacteristics(SunSign sunSign)
    {
        String string;
        switch(sunSign){
            case SAGITTARIUS:
                string = "";
                break;
            case SCORPIO:
                string = "";
                break;
            case PISCES:
                string = SunSignInfo.PISCES;
                break;
            case AQUARIUS:
                string = SunSignInfo.AQUARIUS;
                break;
            case LEO:
                string = SunSignInfo.LEO;
                break;
            case LIBRA:
                string = SunSignInfo.LIBRA;
                break;
            case ARIES:
                string = SunSignInfo.ARIES;
                break;
            case TAURUS:
                string = SunSignInfo.TAURUS;
                break;
            case CAPRICORN:
                string = SunSignInfo.CAPRICORN;
                break;
            case CANCER:
                string = "";
                break;
            case VIRGO:
                string = "";
                break;
            case GEMINI:
                string = "";
                break;
            default:
                string = "";
                break;
        }
        return string;
    }
}
