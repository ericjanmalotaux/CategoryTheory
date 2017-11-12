package nl.malotaux.eric;


import org.junit.Test;

import java.util.Date;

import static nl.malotaux.eric.Chapter1.compose;
import static nl.malotaux.eric.Chapter1.identity;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Chapter1Test {

    @Test
    public void testStringIdentity() throws Exception {
        assertThat(identity("Hoi"), is("Hoi"));
    }

    @Test
    public void testIntegerIdentity() throws Exception {
        assertThat(identity(42), is(42));
    }

    @Test
    public void testCompose() {
        assertThat(identity(compose(Object::toString, String::length).apply(new Date())), is(28));
    }

}