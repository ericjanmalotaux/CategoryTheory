package nl.malotaux.eric;

public class Chapter6 {
    static interface Shape {
        float area();
    }

    static class Circle implements Shape {
        private final float x;

        Circle(float x) {
            this.x = x;
        }

        @Override
        public float area() {
            return (float) (x * x * Math.PI);
        }
    }

    static class Rectangle implements Shape {
        private final float x;
        private final float y;

        Rectangle(float x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public float area() {
            return x * y;
        }
    }

}
