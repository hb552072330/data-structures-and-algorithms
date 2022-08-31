package cn.baymax.example._thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author zhanghongbing
 * @data 2021/11/9
 */
public class CompletableFutureTest2 {
    public static void main(String[] args) {
        List<String> filePaths = Arrays.asList("1", "2", "3","4", "5", "6");
// 异步处理所有文件
        List<CompletableFuture<String>> fileFutures = filePaths.stream()
                .map(filePath -> doSomeThing(filePath))
                .collect(Collectors.toList());
// 将他们合并起来
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                fileFutures.toArray(new CompletableFuture[fileFutures.size()])
        );


        CompletableFuture<Void> headerFuture=CompletableFuture.allOf(allFutures);
        try {
            headerFuture.join();
        } catch (Exception ex) {
            //......
        }
        System.out.println("all done. ");
    }

    private static CompletableFuture<String> doSomeThing(String filePath) {
        return CompletableFuture.supplyAsync(()->{
            //自定义业务操作
            try {
                System.out.printf("thread %s start \r\n", Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.printf("thread %s end \r\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return filePath;
        });
    }
}
