package cn.baymax.question.alibaba;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author zhanghongbing
 * @data 2021/8/19
 */
public class _SynchronousQueue {
    public static void main(String[] args) throws Exception {

        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        queue.put(1);
        System.out.print(queue.offer(1) + " ");
        System.out.print(queue.offer(2) + " ");
        System.out.print(queue.offer(3) + " ");
        System.out.print(queue.take() + " ");
        System.out.println(queue.size());

        //new Thread(() -> {
        //    for (int i = 0; i < 2; i++) {
        //        try {
        //            System.out.println("start put");
        //            queue.put(12);
        //            System.out.println(queue.offer(12) + " put offer  ");
        //            System.out.println(queue.offer(11) + " put offer  ");
        //            TimeUnit.MILLISECONDS.sleep(1000);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //        System.out.println("end put");
        //    }
        //}).start();
        //new Thread(() -> {
        //    for (int i = 0; i < 2; i++) {
        //        try {
        //            TimeUnit.MILLISECONDS.sleep(500);
        //            System.out.println("start take");
        //            System.out.println(queue.offer(12) + " take offer  ");
        //            System.out.println(queue.offer(11) + " take offer  ");
        //            queue.take();
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //        System.out.println("end take");
        //    }
        //
        //}).start();
        //Thread.currentThread().join();

    }
//• A. true true true 1 3
//• B. true true true (阻塞)
//• C. false false false null 0
//• D. false false false (阻塞)
//    答案 D
}
