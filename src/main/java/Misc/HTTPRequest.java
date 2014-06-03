package Misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Michael.Shreiber
 * Date: 10/21/13
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class HTTPRequest {
    public static void main(String[] args) throws Exception {
        String query = "green";
        String urlName = "http://www.google.com/search?q=" + query;
        URL url = new URL(urlName);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("User-Agent",
                "Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;

        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        Pattern pattern = Pattern.compile("<div> (.*?) </div>"); //<div>About 1,620,000 results</div>
        while ((line = in.readLine()) != null) {
            Matcher m = pattern.matcher(line);
            if (m.find()) {
                System.out.println(m.group(1)); // m.group(1) coresponds to results number: i.e.: 1,620,000
            }
        }
        in.close();

/*        URL url = new URL("https://www.google.com/search?source=ig&rlz=&q=java+build+a+request+to+google+translate+tts#q=java+build+http+request");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(
                httpCon.getOutputStream());
        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
        out.close();*/

    }
}
