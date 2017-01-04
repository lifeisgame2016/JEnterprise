package javaee.semaphore.mod3;

/**
 * Created by Den on 02.09.2016.
 */
public class SemaphoreImpl implements Semaphore {
    private int permits;
    private final int MAX_PERMITS;

    public SemaphoreImpl(int permits, int maxPermits) {
        this.permits = permits;
        this.MAX_PERMITS = maxPermits;
    }

    @Override
    public synchronized void acquire() throws InterruptedException {
        if (this.permits > 0) {
            this.permits--;
        } else {
            this.wait();
        }
    }

    @Override
    public synchronized void acquire(int permits) throws InterruptedException {
        if (permits < 0) {
            System.out.println("Permits number must be > 0");
            return;
        }
        if (this.permits >= permits) {
            this.permits -= permits;
        } else if (this.permits > 0) {
            this.notify();
        } else {
            this.wait();
        }
    }

    @Override
    public synchronized void release() {
        if (this.permits < MAX_PERMITS) {
            this.permits++;
        } else {
            System.out.println("Cannot add permits. Max number of permits has been reached already.");
        }
        this.notify();

    }

    @Override
    public synchronized void release(int permits) {
        if (permits < 0) {
            System.out.println("Permits number must be > 0");
            return;
        }
        if (this.permits + permits <= MAX_PERMITS) {
            this.permits += permits;
        } else if (this.permits + permits > MAX_PERMITS) {
            this.permits = MAX_PERMITS;
        } else {
            System.out.println("Cannot add permits. Max number of permits has been reached already.");
        }
        this.notify();
    }

    @Override
    public synchronized int getAvailablePermits() {
        return this.permits;
    }
}
