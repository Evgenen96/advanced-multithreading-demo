package main.java.com.epam.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CF_5 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void> result = CompletableFuture.supplyAsync(() -> "Yuri Gagarin")
				.thenCombineAsync(CompletableFuture.supplyAsync(() -> "German Titov"), CF_5::pickYura)
				.thenCombineAsync(CompletableFuture.supplyAsync(() -> "Grigori Nelubov"), CF_5::pickYura)
				.thenApply(String::toUpperCase)
				.thenAcceptAsync(s -> System.out.println("First was " + s));
		
		Thread.sleep(1000);
		System.out.println(result.isDone());
	}

	private static String pickYura(String s1, String s2) {
		return "Yuri Gagarin";
	}

}
