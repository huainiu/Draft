package JavaCookbook.Network;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Michael.Shreiber on 2/13/14.
 */
public class NetworkClient_Socket {

    //A simple demonstration of setting up a Java network client.
    public static void testSocketConnection(String server_name) {
        try {
            Socket sock = new Socket(server_name, 80);
            //Finally, we can read and write on the socket.
            System.out.println(" *** Connected to " + server_name + " ***");
            //do the I/O here ..
            sock.close();
        } catch (java.io.IOException e) {
            System.err.println("error connecting to " +
                    server_name + ": " + e);
            return;
        }
    }

    //Getting Inet Address and server's name.
    public static void testInetAddress(String ipNumber, String hostName) throws UnknownHostException {
        System.out.println(hostName + "'s address is " +
                InetAddress.getByName(hostName).getHostAddress());
        System.out.println(ipNumber + "'s name is " +
                InetAddress.getByName(ipNumber).getHostName());
    }


    public static void main(String[] args) throws Exception {
        //testSocketConnection("qa2uri1");
        testInetAddress("81.218.16.217", "google.com");


    }
}
