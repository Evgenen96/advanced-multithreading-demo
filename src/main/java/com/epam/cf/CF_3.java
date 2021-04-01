package main.java.com.epam.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CF_3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			return "Sputnik";
		});
		System.out.println(cf.get());

		CompletableFuture<Integer> speed = CompletableFuture.supplyAsync(() -> 1)
				.thenApplyAsync(x -> x * 7)
				.thenApply(x -> x + 1);
		
		System.out.println(speed.get());
	}
}
