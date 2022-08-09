package cn.baymax.example._thread.threadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhanghongbing
 * @data 2021/11/3
 */
public class UnThreadLocalExample implements Runnable {

    // SimpleDateFormat 不是线程安全的
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");

    public static void main(String[] args) throws InterruptedException {
        UnThreadLocalExample obj = new UnThreadLocalExample();
        for (int i = 0; i < 60; i++) {
                if(((i-1)^i) == 0){

                    new Thread(() -> {
                        try {
                            System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.parse("20211104 105455"));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } else {

                    new Thread(() -> {
                        try {
                            System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.parse("20211004 105455"));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }


        }
        //for (int i = 10; i < 20; i++) {
        //    Thread t = new Thread(obj, "" + i);
        //    //Thread.sleep(new Random().nextInt(1000));
        //    t.start();
        //}
        //for (int i = 20; i < 30; i++) {
        //    Thread t = new Thread(obj, "" + i);
        //    //Thread.sleep(new Random().nextInt(1000));
        //    t.start();
        //}
    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.format(new Date()));
        //try {
        //    Thread.sleep(new Random().nextInt(1000));
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        //new SimpleDateFormat();
        //System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + formatter.toPattern());
    }

}