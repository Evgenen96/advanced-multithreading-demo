package main.java.com.epam.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CF_2 {
	private static final String GALILEO = "Galileo";

	public static void main(String[] args) {
		CompletableFuture<String> cf = new CompletableFuture<>();
		System.out.println(cf.isDone());

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(() -> {
			cf.complete("Go th the stars");
		});

		if (cf.getNow(GALILEO).equals(GALILEO)) {
			if (!cf.isCancelled()) {
				cf.cancel(false);
			}
		} else {
			System.out.println(cf.getNow("Kopernik"));
		}
	}
}
