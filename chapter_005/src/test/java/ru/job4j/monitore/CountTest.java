package ru.job4j.monitore;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Count Test.
 */
public class CountTest {

    /**
     * Thread with Count.
     */
    private class ThreadCount extends Thread {
        private final Count count;

        private ThreadCount(final Count count) {
            this.count = count;
        }

        @Override
        public void run() {
            this.count.increment();
        }
    }

    @Test
    public void testWhenExecute2ThreadThen2() throws InterruptedException {
        final Count count = new Count();

        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);

        first.start();
        second.start();

        first.join();
        second.join();

        assertThat(count.get(), is(2));
    }
}