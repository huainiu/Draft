package LT;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.util.*;

/**
 * Created by Michael.Shreiber on 12/29/13.
 */
public class Ngrams {
    int n = 0;
    HashMap<String, ArrayList<Integer>> data = new HashMap<String, ArrayList<Integer>>();

    public HashMap<String, ArrayList<Integer>> parseCSV(String csv) throws IOException {
        CsvReader reader = new CsvReader(csv);
        reader.readHeaders();
        HashMap<String, ArrayList<Integer>> data = new HashMap<String, ArrayList<Integer>>();
        ArrayList<Integer> n1 = new ArrayList<Integer>();
        ArrayList<Integer> n2 = new ArrayList<Integer>();
        ArrayList<Integer> n3 = new ArrayList<Integer>();
        ArrayList<Integer> n4 = new ArrayList<Integer>();
        ArrayList<Integer> n5 = new ArrayList<Integer>();
        ArrayList<Integer> n6 = new ArrayList<Integer>();
        ArrayList<Integer> nS = new ArrayList<Integer>();

        while (reader.readRecord()) {

            n1.add(Integer.valueOf(reader.get("n1")));
            data.put("n1", n1);
            n2.add(Integer.valueOf(reader.get("n2")));
            data.put("n2", n2);
            n3.add(Integer.valueOf(reader.get("n3")));
            data.put("n3", n3);
            n4.add(Integer.valueOf(reader.get("n4")));
            data.put("n4", n4);
            n5.add(Integer.valueOf(reader.get("n5")));
            data.put("n5", n5);
            n6.add(Integer.valueOf(reader.get("n6")));
            data.put("n6", n6);
            nS.add(Integer.valueOf(reader.get("nS")));
            data.put("nS", nS);
        }

        this.data = data;
        return data;
    }

    public List<List<Integer>> ngrams(int n, List<Integer> values, int x) {
        List<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>(1000000);


        for (Integer value : values) {
            int counter = 0;
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> ngram = new ArrayList<Integer>();
                ngram.add(value);
                out.add(ngram);
                counter++;
            }
        }
        System.out.println(out);
        return null;
    }

    public List<List<Integer>> ngrams(int n, List<Integer> values) {
        List<List<Integer>> out = new ArrayList<List<Integer>>(1000000);
        for (int i = 0; i < values.size() - n + 1; i++) {
            out.add(makeNGram(values, i, n));
        }
        return out;
    }

    public List<Integer> makeNGram(List<Integer> values, int start, int length) {
        List<Integer> ngram = new ArrayList<Integer>();
        for (int i = start; i < start + length; i++) {
            ngram.add(values.get(i));
        }
        return ngram.subList(0, ngram.size());
    }

    public ArrayList<Result> countML(String number) {
        ArrayList<Integer> history = new ArrayList<Integer>();
        List<Integer> ngram = ngrams(this.n, data.get(number)).get(ngrams(this.n, data.get(number)).size() - 1);
        history.addAll(ngram.subList(1, ngram.size()));

        List<List<Integer>> ngramsSet = ngrams(this.n, data.get(number));
        List<List<Integer>> ngramsHistory = ngrams(this.n - 1, data.get(number));
        Double countHistory = 0.0;
        for (List<Integer> nh : ngramsHistory) {
            if (nh.equals(history)) {
                countHistory++;
            }
        }

        ArrayList<Result> results = new ArrayList<Result>();

        if (!number.equalsIgnoreCase("nS")) {
            for (int i = 1; i < 38; i++) {
                history.add(i);
                Double countPotential = 0.0;
                for (List<Integer> n : ngramsSet) {
                    if (n.equals(history)) {
                        countPotential++;
                    }
                }
                Result result = new Result();
                result.number = i;
                result.prob = countPotential / countHistory;
                results.add(result);
                history.remove(this.n - 1);
            }
        } else {
            for (int i = 1; i < 8; i++) {
                history.add(i);
                Double countPotential = 0.0;
                for (List<Integer> n : ngramsSet) {
                    if (n.equals(history)) {
                        countPotential++;
                    }
                }
                Result result = new Result();
                result.number = i;
                result.prob = countPotential / countHistory;
                results.add(result);
                history.remove(this.n - 1);
            }
        }

        return results;
    }


    public ArrayList<Result> countPotential(String number) {
        ArrayList<Integer> history = new ArrayList<Integer>();
        List<Integer> ngram = ngrams(this.n, data.get(number)).get(ngrams(this.n, data.get(number)).size() - 1);
        history.addAll(ngram.subList(1, ngram.size()));

        List<List<Integer>> ngramsSet = ngrams(this.n, data.get(number));

        ArrayList<Result> results = new ArrayList<Result>();

        if (!number.equalsIgnoreCase("nS")) {
            for (int i = 1; i < 38; i++) {
                history.add(i);
                Double countPotential = 0.0;
                for (List<Integer> n : ngramsSet) {
                    if (n.equals(history)) {
                        countPotential++;
                    }
                }
                Result result = new Result();
                result.number = i;
                result.prob = countPotential;
                results.add(result);
                history.remove(this.n - 1);
            }
        } else {
            for (int i = 1; i < 8; i++) {
                history.add(i);
                Double countPotential = 0.0;
                for (List<Integer> n : ngramsSet) {
                    if (n.equals(history)) {
                        countPotential++;
                    }
                }
                Result result = new Result();
                result.number = i;
                result.prob = countPotential;
                results.add(result);
                history.remove(this.n - 1);
            }
        }

        return results;
    }


    public static void main(String[] args) throws IOException {
        Ngrams ng = new Ngrams();
        ng.n = 2;
        ng.parseCSV("C:\\Tests\\_myTest\\Lotto.csv");

        System.out.println("ML");
        //n1
        ArrayList<Result> results1 = ng.countML("n1");
        Collections.sort(results1, new Comparator<Result>() {
            public int compare(Result r1, Result r2) {
                Double p1 = r1.prob;
                Double p2 = r2.prob;
                return p1.compareTo(p2) * -1;
            }

            ;
        });
        System.out.println("n1 :" + results1.subList(0, 4));

        //n2
        ArrayList<Result> results2 = ng.countML("n2");
        Collections.sort(results2, new Comparator<Result>() {
            public int compare(Result r1, Result r2) {
                Double p1 = r1.prob;
                Double p2 = r2.prob;
                return p1.compareTo(p2) * -1;
            }

            ;
        });
        System.out.println("n2 :" + results2.subList(0, 4));

        //n3
        ArrayList<Result> results3 = ng.countML("n3");
        Collections.sort(results3, new Comparator<Result>() {
            public int compare(Result r1, Result r2) {
                Double p1 = r1.prob;
                Double p2 = r2.prob;
                return p1.compareTo(p2) * -1;
            }

            ;
        });
        System.out.println("n3 :" + results3.subList(0, 4));

        //n4
        ArrayList<Result> results4 = ng.countML("n4");
        Collections.sort(results4, new Comparator<Result>() {
            public int compare(Result r1, Result r2) {
                Double p1 = r1.prob;
                Double p2 = r2.prob;
                return p1.compareTo(p2) * -1;
            }

            ;
        });
        System.out.println("n4 :" + results4.subList(0, 4));

        //n5
        ArrayList<Result> results5 = ng.countML("n5");
        Collections.sort(results5, new Comparator<Result>() {
            public int compare(Result r1, Result r2) {
                Double p1 = r1.prob;
                Double p2 = r2.prob;
                return p1.compareTo(p2) * -1;
            }

            ;
        });
        System.out.println("n5 :" + results5.subList(0, 4));

        //n5
        ArrayList<Result> results6 = ng.countML("n6");
        Collections.sort(results6, new Comparator<Result>() {
            public int compare(Result r1, Result r2) {
                Double p1 = r1.prob;
                Double p2 = r2.prob;
                return p1.compareTo(p2) * -1;
            }

            ;
        });
        System.out.println("n6 :" + results6.subList(0, 4));

        //n5
        ArrayList<Result> resultsS = ng.countML("nS");
        Collections.sort(resultsS, new Comparator<Result>() {
            public int compare(Result r1, Result r2) {
                Double p1 = r1.prob;
                Double p2 = r2.prob;
                return p1.compareTo(p2) * -1;
            }

            ;
        });
        System.out.println("nS :" + resultsS.subList(0, 4));

        //System.out.println("Count Potential");
        //TODO: to add potential count.


    }
}