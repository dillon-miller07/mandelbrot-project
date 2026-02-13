
public class Mandelbrot {

    // Standard Mandelbrot settings
    public static final int MAX_ITERATIONS = 1000;
    public static final double ESCAPE_RADIUS_SQUARED = 4.0;

    /**
     * Returns the number of iterations before the point escapes.
     * If it never escapes, returns MAX_ITERATIONS.
     */
    public static int escapeTime(ComplexNumber c) {
        ComplexNumber z = new ComplexNumber(0, 0);
        int iterations = 0;

        while (z.absSquared() <= ESCAPE_RADIUS_SQUARED && iterations < MAX_ITERATIONS) {
            z = z.times(z).plus(c);  // z = z² + c
            iterations++;
        }

        return iterations;
    }
}