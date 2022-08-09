package cn.baymax.example._thread.threadLocal;

import java.lang.reflect.Field;

/**
 * @author zhanghongbing
 * @data 2022/4/2
 */
public class ThreadLocalSoftReferenceTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Thread t = new Thread(()->test("abc",false));
        t.start();
        t.join();
        System.out.println("--gc后--");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();
        System.out.println(16 >>> 1);
    }

    private static void test(String s,boolean isGC)  {
        try {
            ThreadLocal<Object> threadLocal = new ThreadLocal<>();
            threadLocal.set(s);
            //threadLocal = null;//失去对threadLocal的强引用 ,help gc
             threadLocal.set("231");
            if (isGC) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object threadLocalMap = field.get(t);
            Class<?> tlmClass = threadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(threadLocalMap);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
