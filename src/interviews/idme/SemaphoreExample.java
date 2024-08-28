package interviews.idme;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	private final Semaphore semaphore = new Semaphore(3); // 3 permits

	public void accessResource() {
		try {
			semaphore.acquire(); // Acquire a permit
			System.out.println(Thread.currentThread().getName() + " is accessing the resource");
			Thread.sleep(1000); // Simulate resource access
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release(); // Release the permit
			System.out.println(Thread.currentThread().getName() + " has released the resource");
		}
	}

	public static void main(String[] args) {
		SemaphoreExample example = new SemaphoreExample();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> example.accessResource()).start();
		}
	}
}
