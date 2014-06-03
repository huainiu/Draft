package JavaCookbook.Network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * You wish to find out about the computer’s networking arrangements (interfaces).
 * Each interface has an operating system-defined name.
 * The NetworkInterface class lets you find out. It has static methods for listing the interfaces
 * and other methods for finding the addresses associated with a given interface.
 * Running it prints the names of all the local interfaces.
 * <p/>
 * Created by Michael.Shreiber on 2/17/14.
 */
public class NetworkInterfaceDemo {

    public static void getCompDetails(String host) throws SocketException, UnknownHostException {

        // Try to get the Interface for a given local (this machine's) address
        InetAddress destAddr = InetAddress.getByName(host);
        try {
            NetworkInterface dest = NetworkInterface.getByInetAddress(destAddr);
            System.out.println("Address for " + destAddr + " is " + dest);
            System.out.println(dest.getDisplayName());
            // And its address(es)
            Enumeration addrs = dest.getInetAddresses();
            while (addrs.hasMoreElements()) {
                InetAddress addr = (InetAddress) addrs.nextElement();
                System.out.println(addr);
            }
        } catch (SocketException ex) {
            System.err.println("Couldn't get address for " + destAddr);
        }
    }

    public static void test() throws SocketException {
        Enumeration list = NetworkInterface.getNetworkInterfaces();
        while (list.hasMoreElements()) {
            // Get one NetworkInterface
            NetworkInterface iface = (NetworkInterface) list.nextElement();
            // Print its name
            System.out.println(iface.getDisplayName());
            Enumeration addrs = iface.getInetAddresses();
            // And its address(es)
            while (addrs.hasMoreElements()) {
                InetAddress addr = (InetAddress) addrs.nextElement();
                System.out.println(addr);
            }
        }
    }


    public static void main(String[] a) throws UnknownHostException, SocketException {

        String host2 = "localhost";
        getCompDetails(host2);
        test();

    }
}
