package JavaCookbook.Network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Michael.Shreiber on 2/16/14.
 */
public class DaytimeUDP {
    //The UDP port number
    public final static int DAYTIME_PORT = 13;
    //A buffer plenty big enough for the date string
    protected final static int PACKET_SIZE = 100;

    // main program
    public static void main(String[] argv) throws IOException {
/*        if (argv.length < 1) {
            System.err.println("usage: java DaytimeUDP host");
            System.exit(1);
        }*/
        //String host = argv[0];
        String host = "exttagsvr";
        InetAddress servAddr = InetAddress.getByName(host);
        DatagramSocket sock = new DatagramSocket();
        // Allocate the data buffer
        byte[] buffer = new byte[PACKET_SIZE];
        // The udp packet we will send and receive
        DatagramPacket packet = new DatagramPacket(
                buffer, PACKET_SIZE, servAddr, DAYTIME_PORT);
        /* Send empty max-length (-1 for null byte) packet to server */
        packet.setLength(PACKET_SIZE - 1);
        sock.send(packet);
        System.out.println("net" + ", " + "Sent request");
        // Receive a packet and print it.
        sock.receive(packet);
        System.out.println("net" + ", " + "Got packet of size " + packet.getLength());
        System.out.print("Date on " + host + " is " +
                new String(buffer, 0, packet.getLength()));
    }

}
