package cn.baymax.example._thread.pool;

import java.util.concurrent.Callable;

/**
 * @author zhanghongbing
 * @data 2021/11/12
 */
public class MyCallable implements Callable<String > {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //返回执行当前 Callable 的线程名字
        return Thread.currentThread().getName();
    }
}
