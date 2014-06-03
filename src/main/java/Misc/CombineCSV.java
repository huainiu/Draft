package Misc; /**
 * Created with IntelliJ IDEA.
 * User: Michael.Shreiber
 * Date: 10/22/13
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;


public class CombineCSV {
    private static String dir = "";

    public ArrayList<String> listFiles(String dir) {
        ArrayList<String> filesList = new ArrayList<String>();

        File folder = new File(dir);
        File[] files = folder.listFiles();
        for (File f : files) {
            filesList.add(f.toString());
        }

        return filesList;
    }

    public ArrayList<String[]> readCSV(String filePath) throws IOException {
        ArrayList<String[]> csv = new ArrayList<String[]>();

        CsvReader reader = new CsvReader(filePath);
        while (reader.readRecord()) {
            String[] line = reader.getValues();
            csv.add(line);

        }
        return csv;

    }

    public ArrayList<String[]> combineCSVs(ArrayList<String[]> csv) {
        ArrayList<String[]> csvCombined = new ArrayList<String[]>();
        csvCombined.addAll(csv);

        return csvCombined;

    }

    public void csvWriter(ArrayList<String[]> csvCombined) throws IOException {
        CsvWriter writer = new CsvWriter(this.dir + "/_combined1.csv");
        for (String[] line : csvCombined) {
            writer.writeRecord(line);
        }

        writer.close();

    }

    public static void main(String[] args) throws IOException {
        CombineCSV combineCSV = new CombineCSV();
        ArrayList<String> filesList = new ArrayList<String>();

        combineCSV.dir = "\\\\tera\\datatest\\QA\\ContentQA\\_TAGGING\\NewsRoom\\BENCHMARK\\CSV";

        filesList = combineCSV.listFiles(combineCSV.dir);

        for (String s : filesList) {
            System.out.println(s);
        }

        ArrayList<String[]> csvCombined = new ArrayList<String[]>();
        for (String s : filesList) {
            ArrayList<String[]> csv = combineCSV.readCSV(s);
            csvCombined.addAll(csv);
        }

        for (String[] s : csvCombined) {
            System.out.println(s);
        }

        combineCSV.csvWriter(csvCombined);

    }

}
