package nl.malotaux.eric;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Chapter2 {

    public static <T, R> Function<T, R> memoize(Function<T, R> function) {
        return new Function<T, R>() {
            Map<T, R> memo = new HashMap<>();

            @Override
            public R apply(T f) {
                R result = memo.get(f);
                if (result == null) {
                    result = function.apply(f);
                    memo.put(f, result);
                }
                return result;
            }
        };
    }


    public static <T, R> Function<T, R> memoize2(Function<T, R> function) {
        return argument -> {
            Map<T, R> memo = new HashMap<>();
            R result = memo.get(argument);
            if (result == null) {
                result = function.apply(argument);
                memo.put(argument, result);
            }
            return result;
        };
    }

    public static <T, R> void functie() {
        Function<Function<T, R>, Function<T, R>> memoize2 = (Function<T, R> function) -> (T argument) -> {
            Map<T, R> memo = new HashMap<>();
            R result = memo.get(argument);
            if (result == null) {
                result = function.apply(argument);
                memo.put(argument, result);
            }
            return result;
        };
    }


}
