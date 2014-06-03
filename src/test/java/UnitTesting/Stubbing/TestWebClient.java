package UnitTesting.Stubbing;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

import static org.junit.Assert.*;
/**
 * Created by Michael.Shreiber on 3/19/14.
 */
public class TestWebClient {

    //This class creates a handler (by extending the Jetty  AbstractHandler class, and implementing a single method,  handle).
    private class TestGetContentOkHandler extends AbstractHandler {
        @Override
        public void handle(String target, HttpServletRequest request,
                           HttpServletResponse response, int dispatch) throws IOException {
            OutputStream out = response.getOutputStream();

            //we use the Jetty  ByteArrayISO8859Writer class (2) to send back the string "It works" which we write in the HTTP response.
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();

            //The last step is to set the response content length to be the length of the string written
            //to the output stream (this is required by Jetty), and then send the response.
            response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }

    private class TestGetContentNotFoundHandler extends AbstractHandler {
        public void handle(String target, HttpServletRequest request,
                           HttpServletResponse response, int dispatch) throws IOException {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Ignore
    @Before
    public void setUp() throws Exception {
        //Start Jetty and configure it to return "It works" when
        //the http://localhost:8080/testGetContentOk URL is called.
        Server server = new Server(8080);
        TestWebClient t = new TestWebClient();
        Context contentOkContext = new Context(server, "/testGetContentOk");
        contentOkContext.setHandler(t.new TestGetContentOkHandler());

        Context contentNotFoundContext = new Context(server, "/testGetContentNotFound");
        contentNotFoundContext.setHandler(t.new TestGetContentNotFoundHandler());

        server.setStopAtShutdown(true);
        server.start();
    }
    @Ignore
    @After
    public void tearDown() {
        // Stop Jetty.
    }

    //Setting up the first stub test
    @Test
    @Ignore
    public void testGetContentOk() throws Exception {
        WebClient client = new WebClient();
        String result = client.getContent(new URL("http://localhost:8080/testGetContentOk"));
        assertEquals("It works", result);
    }

    //Testing for failure conditions
    @Test
    @Ignore
    public void testGetContentNotFound() throws Exception {
        WebClient client = new WebClient();
        String result = client.getContent(new URL(
                "http://localhost:8080/testGetContentNotFound"));
        assertNull(result);
    }


}
