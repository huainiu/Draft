package Misc;

import java.io.*;

/**
 * Created by Michael.Shreiber on 12/14/13.
 */
public class ReadingFiles {

    //Read input by line
    public static String read (String filename) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null){
            sb.append(s + "\n");
        }
        in.close();

        return sb.toString();
    }


    //Reading input by bytes
    public static void readEOF (String filename) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
        while (in.available() != 0){
            System.out.print((char) in.readByte());
        }
    }


    public static void main(String[] args) throws IOException {
        //System.out.println(read("C:\\_data\\чат.txt"));
        readEOF("C:\\_data\\workspace-sts-3.2.0.RELEASE\\PRPerComanies\\src\\main\\java\\testDB\\Main.java");

    }

}
