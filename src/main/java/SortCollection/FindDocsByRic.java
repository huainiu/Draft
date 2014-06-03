/*
package SortCollection;

import com.clearforest.abstractionLayer.calaisClient.CalaisModel;
import com.clearforest.abstractionLayer.calaisClient.CalaisModelReader;
import com.clearforest.abstractionLayer.calaisClient.engine.Engine;
import com.clearforest.abstractionLayer.calaisModel.DocInfoMeta;
import com.clearforest.abstractionLayer.calaisModel.InstanceInfo;
import com.clearforest.abstractionLayer.calaisModel.RelevanceInfo;
import com.clearforest.abstractionLayer.calaisModel.markupentity.Company;
import com.csvreader.CsvReader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

*/
/**
 * Created by Michael.Shreiber on 2/5/14.
 *//*

public class FindDocsByRic {
    List<String> result = new ArrayList<String>();


    public List<String> listRicsToFind(String file) throws IOException {
        List<String> csv = new ArrayList<String>();

        CsvReader reader = new CsvReader(file);
        while (reader.readRecord()) {
            csv.add(reader.getValues()[0]);
        }
        return csv;
    }


    public void scanRdfs(File dir, String csv) throws Exception {
        Collection<File> files = FileUtils.listFiles(dir, new String[]{"xml"}, true);
        List<String> rics = listRicsToFind(csv);

        for (File f : files) {
            try{
            List<DocRic> list = parseRDF(f.getAbsolutePath());
            for (String ric : rics) {
                for (DocRic dc : list) {
                    if (dc.ric.equalsIgnoreCase(ric)) {
                        this.result.add(dc.filename);
                    }
                }
            }
        }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public List<DocRic> parseRDF(String fileName) throws Exception {

        List<DocRic> listDR = new ArrayList<DocRic>();

        CalaisModel calaisModel = null;
        try {
            calaisModel = CalaisModelReader.readFile(fileName, Engine.Format.RDF);
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
        DocInfoMeta docInfoMeta = calaisModel.getDocInfoMeta();

        for (Company company : companies) {
            List relList = company.getRelevanceInfoList();
            com.clearforest.abstractionLayer.calaisModel.RelevanceInfo relevance = (RelevanceInfo) relList.get(0);

            List<InstanceInfo> list = company.getInstanceInfoList();
            int maxLength = 0;
            InstanceInfo maxInstanceInfo = null;
            for (InstanceInfo instanceInfo : list) {
                if (Integer.valueOf(instanceInfo.getLength()) > maxLength) {
                    maxLength = Integer.valueOf(instanceInfo.getLength());
                    maxInstanceInfo = instanceInfo;
                }
            }

            for (com.clearforest.abstractionLayer.calaisModel.resolvedentity.Company resolvedCompany : company.getResolvedEntityList()) {

                String filePath = fileName;
                String ricValue = "";
                if (resolvedCompany.getPrimaryric() != null) {
                    ricValue = resolvedCompany.getPrimaryric();
                    listDR.add(new DocRic(filePath, ricValue));
                }
            }
        }
        return listDR;
    }

    private class DocRic {
        String filename = "";
        String ric = "";

        DocRic(String file, String ric) {
            this.filename = file;
            this.ric = ric;
        }
    }


    public static void main(String[] args) throws Exception {
        FindDocsByRic docs = new FindDocsByRic();
        docs.scanRdfs(new File("\\\\tera\\Datatest\\QA\\Temp\\Anton\\AddedValuePrivateCompanies\\Output\\production"), "C:\\Tests\\News\\140205_Production_ThaiExch\\RICsThai.csv");

        for (String s : docs.result) {
            System.out.println(s);
        }


    }


}
*/
