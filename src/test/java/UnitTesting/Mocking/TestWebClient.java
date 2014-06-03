package UnitTesting.Mocking;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.Assert.assertEquals;

/**
 * The idea is to be able to test the  getContent method independently of a real HTTP
 * connection to a web server. If you map the knowledge you acquired in section 6.2, it means
 * writing a mock URL in which the  url.openConnection method returns a mock
 * HttpURLConnection.
 * <p/>
 * Created by Michael.Shreiber on 3/23/14.
 */
public class TestWebClient {

    @Test
    @Ignore("experimantal project only for learning purposes.")
    public void testGetContentOk() throws Exception {
        MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
        mockConnectionFactory.setData(new ByteArrayInputStream("It works".getBytes()));

        WebClient client = new WebClient();
        String result = client.getContent(mockConnectionFactory);
        assertEquals("It works", result);
    }
}
