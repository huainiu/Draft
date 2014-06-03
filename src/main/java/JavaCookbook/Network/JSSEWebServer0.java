package JavaCookbook.Network;

import java.net.ServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

/**
 * JSSEWebServer - subclass trivial WebServer0 to make it use SSL.
 * @version $Id: ch17,v 1.4 2004/05/04 18:04:54 ian Exp $
 * Created by Michael.Shreiber on 2/17/14.
 */
public class JSSEWebServer0 extends WebServer0 {

    public static final int HTTPS = 8443;

    public static void main(String[] args) throws Exception {
        System.out.println("DarwinSys JSSE Server 0.0 starting...");
        JSSEWebServer0 w = new JSSEWebServer0();
        w.runServer(HTTPS); // never returns!!
    }

    /**
     * Get an HTTPS ServerSocket using JSSE.
     *
     * @throws ClassNotFoundException if the SecurityProvider cannot be instantiated.
     * @see WebServer0#getServerSocket(int)
     */
    protected ServerSocket getServerSocket(int port) throws Exception {
        SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        return ssf.createServerSocket(port);
    }


}
