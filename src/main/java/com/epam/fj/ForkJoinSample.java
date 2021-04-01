package main.java.com.epam.fj;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinSample {
    public static final Integer FIB_INDEX = 20;

    public static void main(String[] args) throws InterruptedException {
        final ForkJoinPool pool = new ForkJoinPool(20);
        FibonacciTask task = new FibonacciTask(FIB_INDEX);
        
//        pool.execute(task);
//        do {
//        	System.out.println("Parallesim " + pool.getParallelism());
//        	System.out.println("Pool size " + pool.getPoolSize());
//        	System.out.println("# tasks in queue " + pool.getQueuedTaskCount());
//        	Thread.sleep(1000);
//        } while (!task.isDone());
        
       
        Integer fibNumber = (Integer) pool.invoke(task);
        System.out.println("# of tasks is " + FibonacciTask.getTaskCounter());
        System.out.println(fibNumber);
    }
}
