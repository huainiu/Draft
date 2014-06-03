/*
package Misc;

import com.clearforest.abstractionLayer.calaisClient.CalaisModel;
import com.clearforest.abstractionLayer.calaisClient.CalaisModelReader;
import com.clearforest.abstractionLayer.calaisClient.engine.Engine;

import java.io.*;


*/
/**
 * Created with IntelliJ IDEA.
 * User: Michael.Shreiber
 * Date: 11/13/13
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 *//*

public class Serialization {

    public CalaisModel parseRDF(String filePath) throws Exception {
        CalaisModel calaisModel = null;
        try {
            calaisModel = CalaisModelReader.readFile(filePath, Engine.Format.RDF);
        } catch (IllegalArgumentException iae) {
            System.out.println("i The exception is below:");
            iae.printStackTrace();
            // returns null if the document is not parsed by CalaisModel, then there is a test for null in the parsRDFs method
            return null;
        } catch (Exception e) {
            System.out.println("e The exception is below:");
            e.printStackTrace();
        }
        return calaisModel;
    }

    public static void main(String[] args) throws Exception {
        Serialization ser = new Serialization();
        CalaisModel cm = ser.parseRDF("\\\\tera\\datatest\\QA\\ContentQA\\CSE\\131111_Newsroom_GS_forYana\\output_T67b419BE\\1ce13b7c-6378-4021-140c-0b011b43e43a_content_US1_New_xml.xml");

        //TO WRITE
        FileOutputStream fout = new FileOutputStream("\\\\tera\\datatest\\QA\\ContentQA\\CSE\\131111_Newsroom_GS_forYana\\calaisModel.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(cm);


        //TO READ
        FileInputStream fin = new FileInputStream("\\\\tera\\datatest\\QA\\ContentQA\\CSE\\131111_Newsroom_GS_forYana\\calaisModel.ser");
        ObjectInputStream ois = new ObjectInputStream(fin);
        CalaisModel cm1 = (CalaisModel) ois.readObject();

        System.out.println(cm1);



    }

}
*/
