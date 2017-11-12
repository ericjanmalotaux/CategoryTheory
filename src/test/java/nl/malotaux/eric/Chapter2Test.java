package nl.malotaux.eric;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Chapter2Test {

    public static Map<String, String> db = new HashMap<>();
    static {
        db.put("Key1", "Value1");
        db.put("Key2", "Value2");
    }

    public String fetch(String key)  {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return db.get(key);
    }

    @Test
    public void testMemoize() throws InterruptedException {
        Function<String, String> memoize = Chapter2.memoize2(this::fetch);
        assertThat(memoize.apply("Key1"), is("Value1"));
        assertThat(memoize.apply("Key1"), is("Value1"));
        assertThat(memoize.apply("Key2"), is("Value2"));
        assertThat(memoize.apply("Key2"), is("Value2"));
    }
}
