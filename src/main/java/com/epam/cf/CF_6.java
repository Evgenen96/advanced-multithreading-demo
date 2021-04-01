package main.java.com.epam.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// if important what cf was first
public class CF_6 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> ussrMoon = CompletableFuture.supplyAsync(() -> "USSR")
				.thenApplyAsync(s-> {
					
					s+=" are Moon communists";
					return s;
				});
		CompletableFuture<String> usaMoon = CompletableFuture.supplyAsync(() -> "USA")
				.thenApply(s-> {
					s+=" built the first Moon base";
					return s;
				}); 
		// who first?
		ussrMoon.acceptEitherAsync(usaMoon,System.out::println);
		Thread.sleep(5000);
	
	}

}
