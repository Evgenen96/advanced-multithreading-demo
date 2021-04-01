package main.java.com.epam.futuresample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureSample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String> Jules_Verne = () -> {
			System.out.println("The romance was written");
			return "De la terra a la lune";
		
		};
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<String> firstTripOutTheEarth = executorService.submit(Jules_Verne);
		
		System.out.println(firstTripOutTheEarth.isDone());
		
		Thread.sleep(1000);
		System.out.println(firstTripOutTheEarth.isDone());
		System.out.println(firstTripOutTheEarth.get());
	}
 
}
