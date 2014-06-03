package JavaCookbook.Network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Michael.Shreiber on 2/16/14.
 */
public class DaytimeTCP {
    //The TCP port for the object time service.
    public static final short TIME_PORT = 1951;

    public static void main(String[] argv) {
        String hostName = "exttagsvr";
/*        if (argv.length == 0)
            hostName = "qa2uri1";
        else
            hostName = argv[0];*/
        try {
            Socket sock = new Socket(hostName, TIME_PORT);
            ObjectInputStream is = new ObjectInputStream(new
                    BufferedInputStream(sock.getInputStream()));
            // Read and validate the Object
            Object o = is.readObject();
            if (!(o instanceof Date))
                throw new IllegalArgumentException("Wanted Date, got " + o);
            // Valid, so cast to Date, and print
            Date d = (Date) o;
            System.out.println("Time on " + hostName + " is " + d.toString());
        } catch (ClassNotFoundException e) {
            System.err.println("Wanted date, got INVALID CLASS (" + e + ")");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
