package UnitTesting.Stubbing;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;

/**
 * An example of Jetty initiation.
 * Created by Michael.Shreiber on 3/19/14.
 */
public class JettySample {

    public static void main(String[] args) throws Exception {
        //We start by creating the Jetty  Server object
        //and specifying in the constructor which port to listen to for HTTP requests (port 8080)
        Server server = new Server(8080);
        //we create a Context object that processes the HTTP requests and passes them to various handlers.
        //You map the context to the already created server instance, and to the root (/) URL
        Context root = new Context(server, "/");
        //The  setResourceBase method sets the document root from which to serve resources.
        root.setResourceBase("./pom.xml");
        //we attach a ResourceHandler handler to the root to serve files from the file system.
        //Because this handler will return an HTTP 403-Forbidden error if we try list the content of a directory,
        //we specify the resource-base to be a file. In this example, we specify the file  pom.xml in the
        //project’s directory.
        root.setHandler(new ResourceHandler());
        //Finally, we start the server
        server.start();
    }
}