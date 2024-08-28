package interviews.idme;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
	public static void main(String[] args) {
		ExecutorExample executorExample = new ExecutorExample();
		// Create a thread pool with 10 threads
		ExecutorService executor = Executors.newFixedThreadPool(10);

		// Submit 15 tasks to the executor
		for (int i = 0; i < 15; i++) {
			executor.submit(executorExample.new MyRunnable());
		}

		// Shutdown the executor
		executor.shutdown();

		// Optional: Await termination
		try {
			if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
				executor.shutdownNow(); // Force shutdown if tasks did not complete in time
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}

		System.out.println("All tasks submitted.");
	}

	public class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("Executing task in thread: " + Thread.currentThread().getName());
		}
	}

}
