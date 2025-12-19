package cn.baymax.mac05;

public class LeakyBucket {
    private int capacity;//漏斗容量
    private int rate;//漏斗出水速率
    private int water;//当前水量
    private long lastLeakTime;//上次漏水时间

    public LeakyBucket(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.water = 0;
        this.lastLeakTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest(int tokens) {
        leak();//漏水
        if (water + tokens <= capacity) {
            water += tokens;
            return true;
        } else {
            return false;
        }
    }

    private void leak() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastLeakTime;
        int leakedTokens = (int) (elapsedTime * rate / 1000);//漏出的令牌数量
        if (leakedTokens > 0) {
            water = Math.max(0, water - leakedTokens);
            lastLeakTime = currentTime;
        }
    }


    public static void main(String[] args) {
        LeakyBucket bucket = new LeakyBucket(10, 2); // 漏斗容量为10，流出速率为2个令牌/秒
        for (int i = 1; i <= 25; i++) {
            if (bucket.allowRequest(1)) {
                System.out.println("Request " + i + " allowed");
            } else {
                System.out.println("Request " + i + " denied");
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
