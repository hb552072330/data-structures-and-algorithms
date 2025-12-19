package cn.baymax.mac05;

public class DeadlockDemo {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "get lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "get lock2");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "get lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + "get lock1");
                }
            }
        }).start();
    }
}
