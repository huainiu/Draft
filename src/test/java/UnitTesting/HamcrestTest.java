package UnitTesting;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by Michael.Shreiber on 3/16/14.
 */
public class HamcrestTest {
    private List<String> values;
    private Map<String, String> map;

    @Before
    @Ignore ("experimantal project only for learning purposes.")
    public void setUpList() {
        values = new ArrayList<String>();
        values.add("x");
        values.add("y");
        values.add("z");

        map = new HashMap<String, String>();
        map.put("a", "b");
        map.put("c", "d");
    }

    @Test
    @Ignore ("experimantal project only for learning purposes.")
    public void withHamcrest() {
        assertThat(values, hasItem(anyOf(equalTo("1"), equalTo("z"), equalTo("3"))));
        //assertThat(map, hasKey(anyOf(equalTo("1"), equalTo("2"), equalTo("3"))));
    }

}
