package main.java.com.epam.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CF_4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			return "Sputnik with dogs";
		}).thenApplyAsync(s-> {
			System.out.println(Thread.currentThread().getName());
			return s+= ": Belka";
		}).thenApply(s-> {
			System.out.println(Thread.currentThread().getName());
			return s+= " & Strelka";
		}).thenAcceptAsync(System.out::println);
		
		CompletableFuture.supplyAsync(() -> "Sputnik with cats")
		.thenApplyAsync(s-> s+= ": Meow")
		.thenApply(s-> s+= "  Meeoooooow")
		.thenRunAsync(() -> {
			System.out.println("Nobody");
		});
		
		Thread.sleep(5000);
	}
	
	
}
