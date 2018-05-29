package ru.job4j.monitore;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * User Storage Test.
 */
public class UserStorageTest {
    /**
     * Thread with UserStorage.
     */
    private class ThreadUserStorage extends Thread {
        private final UserStorage userStorage;

        ThreadUserStorage(UserStorage userStorage) {
            this.userStorage = userStorage;
        }

        @Override
        public void run() {
            this.userStorage.transfer(1, 2, 50);
        }
    }

    @Test
    public void testWhenExecute2ThreadThen2() throws InterruptedException {
        final UserStorage testInstance = new UserStorage();

        Thread first = new UserStorageTest.ThreadUserStorage(testInstance);
        Thread second = new UserStorageTest.ThreadUserStorage(testInstance);

        testInstance.add(new User(1, 300));
        testInstance.add(new User(2, 200));

        assertTrue(testInstance.containsId(1));
        assertTrue(testInstance.containsId(2));

        first.start();
        second.start();

        first.join();
        second.join();

        assertThat(testInstance.getAmountById(1), is(200));
        assertThat(testInstance.getAmountById(2), is(300));
    }

}