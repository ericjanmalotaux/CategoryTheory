package nl.malotaux.eric;


import io.vavr.PartialFunction;
import io.vavr.control.Option;

public class Chapter4 {

    static Option<Double> safeRoot(double x) {
        return x < 0 ? Option.none() : Option.some(Math.sqrt(x));
    }

    static Option<Double> safeReciprocal(double x) {
        return x == 0 ? Option.none() : Option.some(1 / x);
    }

    static Option<Double> safeRootReciprocal(double x) {
        return safeReciprocal(x).flatMap(Chapter4::safeRoot);
    }

    static Option<Double> safeRootReciprocal2(double x) {
        Option<Double> y = safeReciprocal(x);
        if (y.isDefined()) {
            return safeRoot(y.get());
        } else
            return Option.none();
    }

    static PartialFunction<Double, Double> partialRoot = new PartialFunction<Double, Double>() {

        @Override
        public Double apply(Double x) {
            return Math.sqrt(x);
        }

        @Override
        public boolean isDefinedAt(Double value) {
            return value >= 0;
        }
    };

    static Option<Double> safeRootReciprocal3(double x) {
        return safeReciprocal(x).collect(Chapter4.partialRoot);
    }
}
