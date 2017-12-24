package nl.malotaux.eric;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
        return db.get(key);
    }

    public int seededRandom(long seed) {
        return new Random(seed).nextInt();
    }

    @Test
    public void testMemoize() throws Exception {
        Function<String, String> memoize = Chapter2.memoize(this::fetch);
        assertThat(memoize.apply("Key1"), is(fetch("Key1")));
        assertThat(memoize.apply("Key1"), is(fetch("Key1")));
        assertThat(memoize.apply("Key2"), is(fetch("Key2")));
        assertThat(memoize.apply("Key2"), is(fetch("Key2")));
    }

    @Test
    public void random() throws Exception {
        Function<Long, Integer> memoize = Chapter2.memoize(this::seededRandom);
        assertThat(memoize.apply(1L), is(-1155869325));
        assertThat(memoize.apply(2L), is(-1154715079));
        assertThat(memoize.apply(3L), is(-1155099828));
        assertThat(memoize.apply(1L), is(-1155869325));
        assertThat(memoize.apply(2L), is(-1154715079));
        assertThat(memoize.apply(3L), is(-1155099828));
    }
}
