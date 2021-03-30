package main.java.com.epam.sample1;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinSample {
    public static final Integer FIB_INDEX = 5;

    public static void main(String[] args) {
        final ForkJoinPool pool = new ForkJoinPool();
        FibonacciTask task = new FibonacciTask(FIB_INDEX);

        Integer fibNumber = (Integer) pool.invoke(task);
        System.out.println(fibNumber);
    }
}
