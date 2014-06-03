package JavaCookbook.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The ServerSocket represents the “other end” of a connection, the server that waits
 * patiently for clients to come along and connect to it. You construct a ServerSocket
 * with just the port number. * Since it doesn’t need to connect to another host, it
 * doesn’t need a particular host’s address as the client socket constructor does.
 * Assuming the ServerSocket constructor doesn’t throw an exception, you’re in busi-
 * ness. Your next step is to await client activity, which you do by calling accept() .
 * This call blocks until a client connects to your server; at that point, the accept()
 * returns to you a Socket object (not a ServerSocket ) that is connected in both direc-
 * tions to the Socket object on the client (or its equivalent, if written in another lan-
 * guage). Example 17-1 shows the code for a socket-based server.
 * <p/>
 * Created by Michael.Shreiber on 2/17/14.
 */

//Listen -- make a ServerSocket and wait for connections.
public class Listen {

    //The TCP port for the service.
    public static final short PORT = 9989;

    public static void main(String[] argv) throws IOException {
        ServerSocket sock;
        Socket clientSock;
        try {
            sock = new ServerSocket(PORT);
            while ((clientSock = sock.accept()) != null) {
                // Process it.
                process(clientSock);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    //This would do something with one client.
    static void process(Socket s) throws IOException {
        System.out.println("Accept from client " + s.getInetAddress());
        //The conversation would be here.
        s.close();
    }

}
