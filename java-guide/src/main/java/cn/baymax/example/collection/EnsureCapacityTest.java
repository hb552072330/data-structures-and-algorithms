package cn.baymax.example.collection;

import java.util.ArrayList;

/**
 * @author zhanghongbing
 * @data 2021/10/20
 */
public class EnsureCapacityTest {

    public static void main(String[] args) {
        unCall();
        call();
        unCall();
        call();
        unCall();
        call();
        unCall();
        call();
        System.gc();
        unCall();
        call();
        unCall();
        call();
        unCall();
        call();
    }

    private static void call() {
        ArrayList<Object> list;
        final int N = 10000000;
        list = new ArrayList<Object>();
        long startTime1 = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法后："+(endTime1 - startTime1));
    }

    private static void unCall() {
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前："+(endTime - startTime));
    }
}
