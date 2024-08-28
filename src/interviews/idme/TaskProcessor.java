package interviews.idme;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TaskProcessor {

	public static void main(String args[]) {
		TaskProcessor taskProcessor = new TaskProcessor();
		TaskQueue taskQueue = taskProcessor.new TaskQueue();

		// create a threadpool with 3 workers
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		// start 3 workers to process the queue
		for (int i = 0; i < 3; i++) {
			executorService.execute(taskProcessor.new Worker(taskQueue));
		}

		// simulate adding tasks to the queue
		for (int i = 0; i < 10; i++) {
			taskQueue.addTask("Task:" + i);
		}
		// Shutdown the executor service after tasks are done
		executorService.shutdown();

		try {
			if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
				executorService.shutdownNow(); // Force shutdown if tasks did not complete in time
			}
		} catch (InterruptedException e) {
			executorService.shutdownNow();
		}
	}

	public class TaskQueue {
		private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

		// method to add task to the queue
		public void addTask(String task) {
			try {
				queue.put(task); // Put task in queue, waiting if necessary
				System.out.println("Added task :" + task);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Failed to add task: " + task);
			}
		}

		// Method to retrieve and remove task from queue
		public String getTask() throws InterruptedException {
			return queue.take(); // Retrieve and remove the head of the queue, waiting if necessary
		}
	}

	public class Worker implements Runnable {
		private final TaskQueue taskQueue;

		public Worker(TaskQueue taskQueue) {
			this.taskQueue = taskQueue;
		}

		@Override
		public void run() {
			try {
				while (true) {
					// Check if there's a task available
					String task = taskQueue.getTask();
					processTask(task);
					// Notify after task completion
					onTaskCompleted(task);
					Thread.sleep(2000); // Process task every 2 seconds
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Worker interrupted");
			}
		}

		private void processTask(String task) {
			System.out.println("Processing task: " + task + " by " + Thread.currentThread().getName());
			// Implement your task processing logic here
		}

		private void onTaskCompleted(String task) {
			System.out.println("Task completed: " + task + " by " + Thread.currentThread().getName());
			// You could also call some callback or listener here
		}
	}
}
