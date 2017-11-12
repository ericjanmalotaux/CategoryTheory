package nl.malotaux.eric;

import java.util.function.Function;

class Chapter1 {

    static <T> T identity(T value) {
        return value;
    }

    static <A, B, C> Function<A, C> compose(Function<A, B> f, Function<B, C> g) {
        return (A a) -> g.apply(f.apply(a));
    }
}
