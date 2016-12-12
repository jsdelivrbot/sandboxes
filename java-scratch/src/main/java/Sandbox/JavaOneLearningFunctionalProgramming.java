package Sandbox;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class JavaOneLearningFunctionalProgramming {

	public static String completableFutureTest() throws ExecutionException, InterruptedException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Present");
		return future.get();
	}

	public static void parallelStreamsTest() {
		List<String> list = Lists.asList("Item 1", "Item 2", new String[] {"Item 3"});
		list.parallelStream()
				.peek(name -> System.out.println(Thread.currentThread().getName()))
				.filter(name -> name.contains("2"))
				.collect(Collectors.toList());
	}
}
