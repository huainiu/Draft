package SortCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortArrayList {

    //TODO: this.reportForCSV should be sorted according to map.get("total expected");
    public static ArrayList<HashMap<String, Integer>> sortByTotalExpected(ArrayList<HashMap<String, Integer>> originalReportForCSV){
        ArrayList<HashMap<String, Integer>> sortedReportForCSV = originalReportForCSV;
        Collections.sort(sortedReportForCSV, new MapComparator("Key"));

        return sortedReportForCSV;

    }

    public static void main(String[] args) {
        ArrayList<HashMap<String, Integer>> arr = new ArrayList<HashMap<String, Integer>>();

        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("Key", 1);
        arr.add(map1);

        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        map2.put("Key", 100);
        arr.add(map2);

        HashMap<String, Integer> map3 = new HashMap<String, Integer>();
        map3.put("Key", -100);
        arr.add(map3);

        HashMap<String, Integer> map4 = new HashMap<String, Integer>();
        map4.put("Key", 0);
        arr.add(map4);

        HashMap<String, Integer> map5 = new HashMap<String, Integer>();
        map5.put("Key", 120);
        arr.add(map5);

        for (HashMap<String, Integer> map : arr){
            System.out.println(map);
        }

        System.out.println("*******************************************");

        ArrayList<HashMap<String, Integer>> sortedArr = sortByTotalExpected(arr);

        for (HashMap<String, Integer> map : sortedArr){
            System.out.println(map);
        }

    }
}