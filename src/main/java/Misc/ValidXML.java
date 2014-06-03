package Misc;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Michael.Shreiber
 * Date: 10/22/13
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 *
 * This program corrects invalid XMLs by inserting CDATA into Title and Body of the input file.
 * I use Regex to find the opening and closing tags.
 */
public class ValidXML {
    private String origDir = "";
    private String newDir = "";

    public ArrayList<String> getFilesList(String origDir) {
        origDir = this.origDir;
        ArrayList<String> filesList = new ArrayList<String>();
        ArrayList<File> files = new ArrayList<File>(FileUtils.listFiles(new File(origDir), null, true));
        for (File file : files) {
            filesList.add(file.toString());
        }
        return filesList;
    }


    public String readFileAsString(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        StringBuilder fileContents = new StringBuilder((int) file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");

        try {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            System.out.println(fileContents.toString());
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }

    public void correctXML(String fileContents, String fileName) throws IOException {
        Pattern patternTitle = Pattern.compile("<Title>(.*)</Title>");
        Matcher mTitle = patternTitle.matcher(fileContents);
        if (mTitle.find()) {
            String title = mTitle.group();
            System.out.println("title.substring(7,16): " + title.substring(7, 16));
            if (title.substring(7, 16).equals("<![CDATA[")) {
            } else {
                fileContents = fileContents.replace("<Title>", "<Title><![CDATA[");
                fileContents = fileContents.replace("</Title>", "]]></Title>");
                System.out.println("corrected! >>: " + fileContents);
            }
            System.out.println("!!!!!Title: " + mTitle.group());
        } else {
            System.out.println("Title not found");
        }

        Pattern patternBody = Pattern.compile("<Body>(.*)</Body>", Pattern.DOTALL);
        Matcher mBody = patternBody.matcher(fileContents);
        if (mBody.find()) {
            String body = mBody.group();
            System.out.println("body.substring(6,15): " + body.substring(6, 15));
            if (body.substring(6, 15).equals("<![CDATA[")) {

            } else {
                fileContents = fileContents.replace("<Body>", "<Body><![CDATA[");
                fileContents = fileContents.replace("</Body>", "]]></Body>");
                System.out.println("corrected! >>: " + fileContents);
            }
            System.out.println("!!!!!Body: " + mBody.group());
        } else {
            System.out.println("Body not found");
        }

        FileUtils.writeStringToFile(new File(fileName), fileContents);
    }

    public void correctXMLs() throws IOException {
        ArrayList<String> listOfOrgFiles = getFilesList(this.origDir);

        for (String file : listOfOrgFiles) {
            String fileContents = readFileAsString(file);
            correctXML(fileContents, this.newDir + "\\" + file);
        }
    }


    public static void main(String[] args) throws IOException {
        ValidXML xml = new ValidXML();
        xml.origDir = "\\\\tera\\datatest\\QA\\ContentQA\\_TAGGING\\NewsRoom\\BENCHMARK\\_all";
        xml.newDir = "\\\\tera\\datatest\\QA\\ContentQA\\_TAGGING\\NewsRoom\\BENCHMARK\\_allInputValid";
        xml.correctXMLs();


    }


}
