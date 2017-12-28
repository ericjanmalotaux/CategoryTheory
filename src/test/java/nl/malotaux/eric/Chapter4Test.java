package nl.malotaux.eric;

import io.vavr.control.Option;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class Chapter4Test {

    @Test
    public void safeReciprocal() {
        assertThat(Chapter4.safeReciprocal(5), is(Option.some(0.2)));
        assertThat(Chapter4.safeReciprocal(0.2), is(Option.some(5.0)));
    }

    @Test
    public void safeReciprocalNone() {
        assertThat(Chapter4.safeReciprocal(0), is(Option.none()));
    }

    @Test
    public void safeRoot() {
        assertThat(Chapter4.safeRoot(4), is(Option.some(2.0)));
        assertThat(Chapter4.safeRoot(9), is(Option.some(3.0)));
    }

    @Test
    public void safeRootNone() {
        assertThat(Chapter4.safeRoot(-4), is(Option.none()));
    }

    @Test
    public void safeRootReciprocal() {
        assertThat(Chapter4.safeRootReciprocal(0.25), is(Option.some(2.0)));
    }

    @Test
    public void safeRootReciprocalRootNone() {
        assertThat(Chapter4.safeRootReciprocal(-0.25), is(Option.none()));
    }

    @Test
    public void safeRootReciprocalReciprocalNone() {
        assertThat(Chapter4.safeRootReciprocal(0.0), is(Option.none()));
    }

    @Test
    public void safeRootReciprocal2RootNone() {
        assertThat(Chapter4.safeRootReciprocal2(-0.25), is(Option.none()));
    }

    @Test
    public void safeRootReciprocal2ReciprocalNone() {
        assertThat(Chapter4.safeRootReciprocal2(0.0), is(Option.none()));
    }

    @Test
    public void safeRootReciprocal3RootNone() {
        assertThat(Chapter4.safeRootReciprocal3(-0.25), is(Option.none()));
    }

    @Test
    public void safeRootReciprocal3ReciprocalNone() {
        assertThat(Chapter4.safeRootReciprocal3(0.0), is(Option.none()));
    }
}
