package util;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements AutoCloseable {
    private AtomicInteger count;

    public Counter() {
        count = new AtomicInteger();
    }

    public void increment(){
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }
    public void reset(){
        count = new AtomicInteger(0);
    }

    @Override
    public void close() throws Exception {
        reset();
    }
}
