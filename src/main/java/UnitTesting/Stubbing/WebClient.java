package UnitTesting.Stubbing;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.IOException;

/**
 * Created by Michael.Shreiber on 3/18/14.
 */

public class WebClient {
    public String getContent(URL url) {
        StringBuffer content = new StringBuffer();
        try {
            //opening an HTTP connection using the  HttpURLConnection class
            HttpURLConnection connection = (HttpURLConnection)
                    url.openConnection();
            connection.setDoInput(true);

            //read the stream content until there is nothing more to read
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int count;
            while (-1 != (count = is.read(buffer))) {
                content.append(new String(buffer, 0, count));
            }
        } catch (IOException e) {
            //If an error occurs, we return null
            return null;
        }
        return content.toString();
    }
}
