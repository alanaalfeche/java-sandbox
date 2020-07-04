import java.util.function.Supplier;

/**
 * Calculate runtime performance.
 *
 * Accepts a function and returns the result and the system performance of a
 * function. This function is re-used from Project 1.
 *
 * @author Alana Alfeche
 * @since 23 September 2019
 */
class TimedResult<T> {
    public final T result;
    public final String time;

    public TimedResult(T result, String time) {
        this.result = result;
        this.time = time;
    }

    public static <T> TimedResult<T> time(Supplier<T> supplier) {
        var start = System.nanoTime();
        var result = supplier.get(); // result of the function i.e. strassenMultiply and ordinaryMultiply
        var end = System.nanoTime();
        return new TimedResult(result, ((end - start) * 100 / 1000000) + " ms\n"); // ns -> ms
    }
}