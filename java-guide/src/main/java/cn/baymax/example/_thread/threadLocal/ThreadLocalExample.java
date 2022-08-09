package cn.baymax.example._thread.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author zhanghongbing
 * @data 2021/11/3
 */
public class ThreadLocalExample  implements Runnable{

    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));
    private static final ThreadLocal<Date> DATE_THREAD_LOCAL = ThreadLocal.withInitial(() -> new Date());
    private static final ThreadLocal<Date> DATE_THREAD_LOCAL2 = new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
            //System.out.println("t start");
        }
        System.out.println(21);
    }

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
        //System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+DATE_THREAD_LOCAL.get());
    }

}