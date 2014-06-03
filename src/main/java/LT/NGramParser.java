package LT;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.util.*;

/**
 * Created by Michael.Shreiber on 12/26/13.
 */
public class NGramParser {
    String csvData = "";
    HashMap<String, String> data = new HashMap<String, String>();

    public HashMap<String, String> parseCSV(String csv) throws IOException {
        CsvReader reader = new CsvReader(csv);
        reader.readHeaders();
        HashMap<String, String> data = new HashMap<String, String>();

        int counter = 2;
        String n1 = "";
        String n2 = "";
        String n3 = "";
        String n4 = "";
        String n5 = "";
        String n6 = "";
        String nS = "";

        while (reader.readRecord()) {
            //System.out.println("reading line " + counter + " from CSV");
            counter++;

            n1 = n1.concat(" " + reader.get("n1"));
            n2 = n2.concat(" " + reader.get("n2"));
            n3 = n3.concat(" " + reader.get("n3"));
            n4 = n4.concat(" " + reader.get("n4"));
            n5 = n5.concat(" " + reader.get("n5"));
            n6 = n6.concat(" " + reader.get("n6"));
            nS = nS.concat(" " + reader.get("nS"));
        }

        //System.out.println("n1: " + n1);
        data.put("n1", n1);
        //System.out.println("n2: " + n2);
        data.put("n2", n2);
        //System.out.println("n3: " + n3);
        data.put("n3", n3);
        //System.out.println("n4: " + n4);
        data.put("n4", n4);
        //System.out.println("n5: " + n5);
        data.put("n5", n5);
        //System.out.println("n6: " + n6);
        data.put("n6", n6);
        //System.out.println("nS: " + nS);
        data.put("nS", nS);

        this.data = data;
        return data;
    }


    public static List<String> ngrams(int max, String val) {
        List<String> out = new ArrayList<String>(1000);
        String[] words = val.split(" ");
        for (int i = 0; i < words.length - max + 1; i++) {
            out.add(makeString(words, i, max));
        }
        return out;
    }

    public static String makeString(String[] words, int start, int length) {
        StringBuilder tmp = new StringBuilder(100);
        for (int i = start; i < start + length; i++) {
            tmp.append(words[i]).append(" ");
        }
        return tmp.substring(0, tmp.length() - 1);
    }

    public static List<String> reduceNgrams(List<String> in, int size) {
        if (1 < size) {
            List<String> working = reduceByOne(in);
            in.addAll(working);
            for (int i = size - 2; i > 0; i--) {
                working = reduceByOne(working);
                in.addAll(working);
            }
        }
        return in;
    }

    public static List<String> reduceByOne(List<String> in) {
        List<String> out = new ArrayList<String>(in.size());
        int end;
        for (String s : in) {
            end = s.lastIndexOf(" ");
            out.add(s.substring(0, -1 == end ? s.length() : end));
        }
        //the last one will always reduce twice - words 0, n-1 are in the loop this catches the words 1, n
        String s = in.get(in.size() - 1);
        out.add(s.substring(s.indexOf(" ") + 1));
        return out;
    }

    public HashMap<String, String> countNgrams(List<String> ngrams, String ngram) {
        double counter = 0.0;
        for (String s : ngrams) {
            if (ngram.equalsIgnoreCase(s)) {
                counter++;
            }
        }

        HashMap<String, String> map = new HashMap<String, String>();
        map.put(ngram, (counter + ""));
        return map;
    }


    public static void main(String[] args) throws IOException {
        //List<String> ngrams = ngrams(3, "Your text goes here, actual mileage may vary");
        //reduceNgrams(ngrams, 3);

        int n = 2;
        String ngram1 = "5 9 ";
        String ngram2 = "20 18 ";
        String ngram3 = "21 25 ";
        String ngram4 = "26 30 ";
        String ngram5 = "30 33 ";
        String ngram6 = "27 35 37 ";
        String ngramS = "5 ";


        NGramParser parser = new NGramParser();
        HashMap<String, String> data = parser.parseCSV("C:\\Tests\\_myTest\\LottoFull.csv");

        List<String> ngramsN1 = ngrams(n, data.get("n1"));
        List<String> ngramsN2 = ngrams(n, data.get("n2"));
        List<String> ngramsN3 = ngrams(n, data.get("n3"));
        List<String> ngramsN4 = ngrams(n, data.get("n4"));
        List<String> ngramsN5 = ngrams(n, data.get("n5"));
        List<String> ngramsN6 = ngrams(n, data.get("n6"));
        List<String> ngramsNS = ngrams(n, data.get("nS"));
        for (String s : ngramsNS){
            System.out.println(s);
        }

        for (int i = 1; i < 8; i++){
            String s = ngramS + i;
            HashMap<String, String> result = parser.countNgrams(ngramsNS, s);
            System.out.println(result);
        }

    }
}