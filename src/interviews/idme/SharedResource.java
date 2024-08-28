package interviews.idme;

class SharedResource {
    private int value = 0;
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (value != 0) {
                lock.wait(); // Wait if the value is not consumed yet
            }
            value = 1;
            System.out.println("Produced: " + value);
            lock.notify(); // Notify the consumer
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (value == 0) {
                lock.wait(); // Wait if there's nothing to consume
            }
            System.out.println("Consumed: " + value);
            value = 0;
            lock.notify(); // Notify the producer
        }
    }
}
