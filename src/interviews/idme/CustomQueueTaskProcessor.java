package interviews.idme;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class CustomQueueTaskProcessor {
	public class TaskQueue<T> {
		private Queue<T> queue = new LinkedList<>();
		private Lock lock = new ReentrantLock();
		private Condition notEmpty = lock.newCondition();
		private Condition notFull = lock.newCondition();
		private final int capacity;

		public TaskQueue(int capacity) {
			this.capacity = capacity;
		}

		// enqueue
		private void enqueue(T item) throws InterruptedException {
			lock.lock();
			try {
				while (queue.size() == capacity) {
					notFull.await();
				}
				queue.offer(item);
				System.out.println(item + " pushed successfuly");
				notEmpty.signalAll();
			} finally {
				lock.unlock();
			}
		}

		// dequeue
		private T dequeue() throws InterruptedException {
			lock.lock();
			try {
				while (queue.isEmpty()) {
					notEmpty.await();
				}
				T item = queue.poll();
				System.out.println("item dequeued:" + item);
				notFull.signalAll();
				return item;
			} finally {
				lock.unlock();
			}
		}
	}

	public class Worker implements Runnable {
		TaskQueue<String> taskQueue;

		public Worker(TaskQueue<String> taskQueue) {
			this.taskQueue = taskQueue;
		}

		@Override
		public void run() {
			// call dequeue

			while (true) {
				try {
					String item = taskQueue.dequeue();
					processTask(item);
					Thread.sleep(2000);

				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					System.out.println("Worker interrupted");
					break; // Exit the loop if interrupted
				}
			}
		}

		private void processTask(String item) {
			System.out.println("processing task:" + item + "by" + Thread.currentThread().getName());
		}
	}

	public static void main(String args[]) {
		CustomQueueTaskProcessor customQueueTaskProcessor = new CustomQueueTaskProcessor();
		// executor service + execute with workers + enqueue
		// create a threadpool with 3 workers
		TaskQueue<String> taskQueue = customQueueTaskProcessor.new TaskQueue<>(5);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			executor.execute(customQueueTaskProcessor.new Worker(taskQueue));
		}

		for (int i = 0; i < 10; i++) {
			// enqueue
			try {
				taskQueue.enqueue("item:" + i);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		executor.shutdown();

		try {
			if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}
	}
}
