package SortCollection;

import java.util.Comparator;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Michael.Shreiber
 * Date: 10/30/13
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class MapComparator implements Comparator<HashMap<String, Integer>> {
    private final String key;

    public MapComparator(String key) {
        this.key = key;
    }

    @Override
    public int compare(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        // TODO: Null checking, both for maps and values
        Integer firstValue = map1.get(key);
        Integer secondValue = map2.get(key);
        return (firstValue.compareTo(secondValue)) * -1;
    }
}
