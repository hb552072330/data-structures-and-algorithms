package cn.baymax.example._thread;

import java.util.concurrent.CompletableFuture;

/**
 * @author zhanghongbing
 * @data 2021/11/9
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<Void> task1 =
                CompletableFuture.supplyAsync(()->{
                    //自定义业务操作
                    try {
                        System.out.printf("thread %s start \r\n", Thread.currentThread().getName());
                        Thread.sleep(1000);
                        System.out.printf("thread %s end \r\n", Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
        CompletableFuture<Void> task2 =
                CompletableFuture.supplyAsync(()->{
                    //自定义业务操作
                    try {
                        System.out.printf("thread %s start \r\n", Thread.currentThread().getName());
                        Thread.sleep(1000);
                        System.out.printf("thread %s end \r\n", Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
        CompletableFuture<Void> task3 =
                CompletableFuture.supplyAsync(()->{
                    //自定义业务操作
                    try {
                        System.out.printf("thread %s start \r\n", Thread.currentThread().getName());
                        Thread.sleep(1000);
                        System.out.printf("thread %s end \r\n", Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
        CompletableFuture<Void> task4 =
                CompletableFuture.supplyAsync(()->{
                    //自定义业务操作
                    try {
                        System.out.printf("thread %s start \r\n", Thread.currentThread().getName());
                        Thread.sleep(1000);
                        System.out.printf("thread %s end \r\n", Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
        CompletableFuture<Void> task5 =
                CompletableFuture.supplyAsync(()->{
                    //自定义业务操作
                    try {
                        System.out.printf("thread %s start \r\n", Thread.currentThread().getName());
                        Thread.sleep(1000);
                        System.out.printf("thread %s end \r\n", Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
        CompletableFuture<Void> task6 =
                CompletableFuture.supplyAsync(()->{
                    //自定义业务操作
                    try {
                        System.out.printf("thread %s start \r\n", Thread.currentThread().getName());
                        Thread.sleep(1000);
                        System.out.printf("thread %s end \r\n", Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
        CompletableFuture<Void> headerFuture=CompletableFuture.allOf(task1,task2,task3,task4, task5,task6);

        try {
            headerFuture.join();
        } catch (Exception ex) {
            //......
        }
        System.out.println("all done. ");
    }
}
