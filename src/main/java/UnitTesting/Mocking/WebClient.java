package UnitTesting.Mocking;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.IOException;
import java.net.URLConnection;

/**
 * Created by Michael.Shreiber on 3/23/14.
 */
public class WebClient {

    public String getContent(ConnectionFactory connectionFactory) throws IOException {
        StringBuffer content = new StringBuffer();
        try {
            //Open an HTTP connection using the  HttpURLConnection class.
            InputStream is = connectionFactory.getData();
            int count;

            //Read the content until there is nothing more to read.
            while (-1 != (count = is.read())) {
                content.append(new String(Character.toChars(count)));
            }
        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    protected URLConnection createHttpURLConnection(URL url)
            throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

}
