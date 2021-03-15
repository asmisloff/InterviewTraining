import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    @Getter private long count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void inc() {
        lock.lock();
        try {
            System.out.printf("%s: %d -> %d%n", Thread.currentThread().getName(), count, ++count);
        } finally {
            lock.unlock();
        }
    }

    public void dec() {
        lock.lock();
        try {
            System.out.printf("%s: %d -> %d%n", Thread.currentThread().getName(), count, --count);
        } finally {
            lock.unlock();
        }
    }

}
