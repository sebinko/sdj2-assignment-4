package treasury;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Door {
    private final ReentrantReadWriteLock lock;

    public Door() {
        this.lock = new ReentrantReadWriteLock(true);
    }

    public void acquireRead() {
        lock.readLock().lock();
    }

    public void releaseRead() {
        lock.readLock().unlock();
    }

    public void acquireWrite() {
        lock.writeLock().lock();
    }

    public void releaseWrite() {
        lock.writeLock().unlock();
    }
}