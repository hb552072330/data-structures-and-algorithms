package cn.baymax.mac06;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test02 {

    public static int MAXN = 100010;

    public static int[] arr = new int[MAXN];

    public static int n;

   /* public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("t1:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 1){
                try {
                    t1.join(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/


    /*public static void main(String[] args) throws InterruptedException {
       Thread t1 = new Thread(() -> {
           for (int i = 0; i < 10; i++) {
               System.out.println("t1:" + i);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });
       t1.setDaemon(true);
       t1.start();
   }*/
   /* private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                count.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+ ":" + count);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                count.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+ ":" + count);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }*/


   /* static ThreadLocal tl1 = new ThreadLocal();
    static ThreadLocal tl2 = new ThreadLocal();

    public static void main(String[] args) {
        tl1.set("123");
        tl2.set("456");
        Thread t1 = new Thread(() -> {
            System.out.println("t1:" + tl1.get());
            System.out.println("t1:" + tl2.get());
        });
        t1.start();

        System.out.println("main:" + tl1.get());
        System.out.println("main:" + tl2.get());
    }*/

    static int a,b,x,y;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;

            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            if(x == 0 && y == 0){
                System.out.println("第" + i + "次，x = "+ x + ",y = " + y);
            }
        }
    }

}
