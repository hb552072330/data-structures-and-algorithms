package cn.baymax.mac05;

import java.time.Instant;

public class TokenBucket {
    private int capacity;//
    private int rate;//令牌桶产生速率
    private int tokens;//当前令牌的数量
    private Instant lastTokenTime;//上次生成令牌的时间

    public TokenBucket(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.tokens = capacity;
        this.lastTokenTime = Instant.now();
    }

    public synchronized boolean allowRequest() {
        Instant now = Instant.now();
        long elapsedTime = now.toEpochMilli() - lastTokenTime.toEpochMilli();
        int generatedTokens = (int) (elapsedTime * rate / 1000);//根据时间生成令牌的数量
        tokens = Math.min(capacity, tokens + generatedTokens);
        lastTokenTime = now;
        if (tokens > 0) {
            tokens--;//取走一个令牌
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TokenBucket bucket = new TokenBucket(10, 2); // 令牌桶容量为10，令牌产生速率为2个令牌/秒
        for (int i = 1; i <= 15; i++) {
            if (bucket.allowRequest()) {
                System.out.println("Request " + i + " allowed");
            } else {
                System.out.println("Request " + i + " denied");
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
