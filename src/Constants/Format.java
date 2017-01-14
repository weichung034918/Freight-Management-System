package Constants;


import java.util.regex.Pattern;

public class Format {
   private static final String usernamePattern = "(Username|username|password|Password|\\s|\\W)";

    public static boolean matchesUsername(String string){
        return Pattern.matches(usernamePattern,string);
    }
}
