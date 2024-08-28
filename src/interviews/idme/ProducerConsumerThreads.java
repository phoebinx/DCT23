package interviews.idme;

import java.util.LinkedList;
import java.util.Queue;

class DataQueue {
	private Queue<Integer> queue = new LinkedList<>();
	private final int MAX_SIZE = 5;

	// Produce an item and add it to the queue
	public synchronized void produce(int item) throws InterruptedException {
		while (queue.size() == MAX_SIZE) {
			System.out.println("Queue is full, producer is waiting...");
			wait(); // Wait until space becomes available
		}
		queue.add(item);
		System.out.println("Produced: " + item);
		notify(); // Notify the consumer that new data is available
	}

	// Consume an item from the queue
	public synchronized int consume() throws InterruptedException {
		while (queue.isEmpty()) {
			System.out.println("Queue is empty, consumer is waiting...");
			wait(); // Wait until an item is available
		}
		int item = queue.poll();
		System.out.println("Consumed: " + item);
		notify(); // Notify the producer that space is available
		return item;
	}
}

class Producer implements Runnable {
	private DataQueue dataQueue;

	public Producer(DataQueue dataQueue) {
		this.dataQueue = dataQueue;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
				dataQueue.produce(i);
				Thread.sleep(500); // Simulate time taken to produce an item
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {
	private DataQueue dataQueue;

	public Consumer(DataQueue dataQueue) {
		this.dataQueue = dataQueue;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
				dataQueue.consume();
				Thread.sleep(1000); // Simulate time taken to consume an item
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ProducerConsumerThreads {
	public static void main(String[] args) {
		DataQueue dataQueue = new DataQueue();

		Thread producerThread = new Thread(new Producer(dataQueue));
		Thread consumerThread = new Thread(new Consumer(dataQueue));

		producerThread.start();
		consumerThread.start();

		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
