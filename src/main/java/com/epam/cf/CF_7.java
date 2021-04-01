package main.java.com.epam.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// combine some cfs
public class CF_7 {
	private static final String GALILEO = "Galileo";

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Soyuz 19");
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Apollo 18");
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "UFO");
		
		CompletableFuture<Void> cf = CompletableFuture.allOf(future1, future2, future3);
		System.out.println(cf.get());
		
		
		String combined = Stream.of(future1, future2, future3)
				.map(CompletableFuture::join)
				.collect(Collectors.joining(" "));
		
		System.out.println(combined);
			
	
	}

}
