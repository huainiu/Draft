package JavaCookbook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michael.Shreiber on 2/10/14.
 */
public class Regex {


    public static void main(String[] args) {
        String s = "You may find it informative to refer120 back to Table 4-2 and review the full syntax used\n" +
                "here. Note in particular the use of the non-greedy quantifier +? in (.+?) to match\n" +
                "a quoted string12312323234232323; yo42342uwerq23 can’t just use .+ since that would match too much (up to the\n" +
                "quote at the end of the line). Code100000 to extract the various fields such as IP99999999 address,\n" +
                "request, referer URL, and browser version is shownwqd12312 in Example 4-7.";

        Pattern pattern = Pattern.compile("[A-Za-z]+[0-9]+");
        Matcher matcher = pattern.matcher(s);

        while(matcher.find()){
            System.out.println(matcher.group());
        }






    }
}
