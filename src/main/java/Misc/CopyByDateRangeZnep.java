/*
package Misc;

import com.clearforest.abstractionLayer.calaisClient.CalaisModel;
import com.clearforest.abstractionLayer.calaisClient.CalaisModelReader;
import com.clearforest.abstractionLayer.calaisClient.engine.Engine;
import com.clearforest.abstractionLayer.calaisModel.markupentity.Company;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

*/
/**
 * Created by Michael.Shreiber on 1/15/14.
 *//*

public class CopyByDateRangeZnep {

    private static List<File> files = new ArrayList<File>();
    private static String previousDirName = "";
    private static boolean criticalError = false;

    public static void getFiles() throws IOException {
        System.out.println("Reading files...");
        File inputFolder = new File("\\\\znep\\e$\\documents\\FromNep\\nepDownloader\\output");

        Calendar cal = Calendar.getInstance();
        //cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) - 1, 0, 0, 0);
        //Date cutoffDate = cal.getTime();

//        getting the list of all sources folders except PLTS

        List<File> sources = Arrays.asList(inputFolder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File dir) {
                //return !dir.getAbsolutePath().contains("PLTS") && !dir.getAbsolutePath().contains("RTRS") && !dir.getAbsolutePath().contains("ARGS");
                return !dir.getAbsolutePath().contains("PLTS");
            }
        }));

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dirName = dateFormat.format(date);
        //Date previousDate = new Date(date.getTime() - 1 * 24 * 3600 * 1000); //Subtract 1 day

        String[] dates = {"2014-03-01", "2014-03-02", "2014-03-03", "2014-03-04", "2014-03-05", "2014-03-06", "2014-03-07", "2014-03-08", "2014-03-09", "2014-03-10", "2014-03-11", "2014-03-12", "2014-03-13", "2014-03-14", "2014-03-15", "2014-03-16", "2014-03-17", "2014-03-18", "2014-03-19", "2014-03-20", "2014-03-21", "2014-03-22", "2014-03-23", "2014-03-24", "2014-03-25"};
        //String[] dates = {"2014-01-21"};

        for (File f : sources) {
            System.out.println("Processing source " + f.getName());

            //if the folder of previous date exists - add all files from there to total files
            //File subDir = new File(f.getAbsolutePath(), previousDirName);
            for (String date1 : dates) {
                File subDir = new File(f.getAbsolutePath() + "\\" + date1 + "\\");
                if (subDir.exists()) {
                    files.addAll(Arrays.asList(subDir.listFiles()));
                }
            }

        }

        if (files.size() == 0) {
            criticalError = true;
            System.out.println("No new files were found, aborting the run");
        }
        System.out.println("Done looking for files, files found for previous day (" + previousDirName + "): " + files.size());

        System.out.println("copying");

        //random 1000 files
        Collections.shuffle(files);

        List<File> subListInputs = files.subList(0, 3000);
        List<String> subListOutputs = new ArrayList<String>();


*/
/*        for (File f : subListInputs){
            String fileName = f.getAbsolutePath().replace(".","_");
            String fileName1 = fileName.replace("_xml", "_xml.xml");
            //String fileName2 = fileName1.replace("output\\\\[A-Z]*\\\\","output\\\\");
            fileName1 = StringUtils.replace(fileName1,"output\\[A-Z]*\\","output\\");
            String fileName2 = fileName1.replace("znep\\e$\\documents\\FromNep\\nepDownloader\\output\\", "tera\\datatest\\Projects\\OneCalais\\Data\\AutomationData\\DailyAddedValueprivateCompanies\\production");




            //check if there are extractions
            CalaisModel calaisModel = null;
            try {
                calaisModel = CalaisModelReader.readFile(fileName2, Engine.Format.RDF);
            } catch (IllegalArgumentException iae) {
                System.out.println("i The exception is below:");
                iae.printStackTrace();
                // returns null if the document is not parsed by CalaisModel, then there is a test for null in the parsRDFs method
            } catch (Exception e) {
                System.out.println("e The exception is below:");
                e.printStackTrace();
            }
            CalaisModel.Entities markupEntities = calaisModel.getMarkupEntities();
            List<Company> companies = markupEntities.getCompanyList();
            if(companies.size()>1){
                String fileDest = f.getAbsolutePath().replace("\\\\znep\\e$\\documents\\FromNep\\nepDownloader\\output", "\\\\tera\\datatest\\Projects\\OneCalais\\Data\\AutomationData\\DailyAddedValueprivateCompanies\\set1000");
                FileUtils.copyFile(f, new File(fileDest));
                System.out.println("copied files: ");
            }

        }*//*






        for (int i = 0; i < 3000; i++) {
            File f = files.get(i);

            String fileDest = f.getAbsolutePath().replace("\\\\znep\\e$\\documents\\FromNep\\nepDownloader\\output", "\\\\tera\\datatest\\Projects\\OneCalais\\Data\\AutomationData\\DailyAddedValueprivateCompanies\\set3000");
            FileUtils.copyFile(f, new File(fileDest));
            System.out.println("copied files: " + i);
        }
    }


    public static void main(String[] args) throws IOException {
        getFiles();

    }

}*/
