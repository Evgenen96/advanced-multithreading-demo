package main.java.com.epam.sample1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class FibonacciTask extends RecursiveTask {
    private Integer fibIndex;
    private static AtomicInteger taskCounter = new AtomicInteger();
    
    private Map<Integer, Integer> fibMap = new HashMap<>();

    //treshhold
    {
    	fibMap.put(0, 0);
    	fibMap.put(1, 1);
    	fibMap.put(2, 1);
    	fibMap.put(3, 2);
    	fibMap.put(4, 3);
    }
    public FibonacciTask(Integer fibIndex) {
        this.fibIndex = fibIndex;
    }

    public static AtomicInteger getTaskCounter() {
        return taskCounter;
    }

    @Override
    protected Integer compute() {
        if(fibMap.containsKey(fibIndex)) {
        	return fibMap.get(fibIndex);
        }
        final FibonacciTask task1 = new FibonacciTask(fibIndex - 1);
        task1.fork();
        taskCounter.getAndIncrement();
        
        final FibonacciTask task2 = new FibonacciTask(fibIndex - 2);
        Integer result2 = task2.compute();
        taskCounter.getAndIncrement();
        
        Integer result1 = (Integer) task1.join();

        

        int result = result1 + result2;
        return result;
    
    }
}