package OsOps;

import org.jvnet.winp.WinProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Michael on 5/26/2014.
 */
public class WinpDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        //WinProcess process = new WinProcess(9452);
        //process.kill();
        //System.out.println(process.getCommandLine());
        //System.out.println(process.getEnvironmentVariables());

        //String[] stop = {"Elevate64.exe", "cmd.exe", "/c", "sc", "\\\\192.168.126.131", "stop", "Themes"};
        String[] stop = {"Elevate64.exe", "cmd.exe", "sc", "\\\\192.168.126.131", "stop", "Themes"};
        Process p = Runtime.getRuntime().exec(stop);
        p.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }

    }
}
