package interviews.idme;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeQueue<T> {
	private final Queue<T> queue = new LinkedList<>();
	private final Lock lock = new ReentrantLock();
	private final Condition notEmpty = lock.newCondition();
	private final Condition notFull = lock.newCondition();
	private final int capacity;

	public ThreadSafeQueue(int capacity) {
		this.capacity = capacity;
	}

	public void enqueue(T item) throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == capacity) {
				notFull.await(); // wait untill space is available
			}
			queue.add(item);
			System.out.println("Enqueued item:" + item);
			notEmpty.signalAll();// notify waiting threads that an item has been added
		} finally {
			lock.unlock();
		}
	}

	public T dequeue() throws InterruptedException {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				notEmpty.await();
			}
			T item = queue.poll();
			System.out.println("Dequeued: " + item);
			notFull.signalAll();
			return item;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String args[]) {
		ThreadSafeQueue<String> queue = new ThreadSafeQueue<>(5); // queue with capacity 5

		// Producer Thread
		Runnable producer = () -> {
			try {
				for (int i = 1; i <= 10; i++) {
					queue.enqueue("item:" + i);
					Thread.sleep(100);// simuate some delay in production
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		};

		// Consumer Thread
		Runnable consumer = () -> {
			try {
				for (int i = 1; i <= 10; i++) {
					queue.dequeue();
					Thread.sleep(150); // Simulate some delay in consumption
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		};

		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		producerThread.start();
		consumerThread.start();

		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

//
//class Consumer implements Runnable {
//	private final ThreadSafeQueue<String> queue;
//	public Consumer(ThreadSafeQueue<String> queue) {
//		this.queue = queue;
//	}
//	
//	@Override 
//	public void run {
//		  try {
//	            for (int i = 1; i <= 10; i++) {
//	                queue.dequeue();
//	                Thread.sleep(150); // Simulate some delay in consumption
//	            }
//	        } catch (InterruptedException e) {
//	            Thread.currentThread().interrupt();
//	        }
//	}
//}