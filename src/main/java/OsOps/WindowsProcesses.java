package OsOps;

import java.io.*;
import java.util.*;


/**
 * Created by Michael on 5/25/2014.
 */


public class WindowsProcesses {
    public static void main(String args[]) throws IOException {
        // you can pass query/start/stop to respective
        // operation on windows Audio Service while running

        //run in cmd: "runas /profile /user:Administrator /savecred cmd"

        String[] command = {"cmd.exe", "////192.168.126.131", "/c", "sc", "stop", "SDScannerService"};
        //String[] command = {"cmd.exe", "ip", "/c", "sc", "stop", "SDScannerService"};

        try {
            Process process = new ProcessBuilder(command).start();
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
    }
}