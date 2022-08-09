package cn.baymax.example._thread.threadLocal;

/**
 * @author zhanghongbing
 * @data 2022/4/2
 */
public class ThreadLocalHashIncrement {
    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        System.out.println(HASH_INCREMENT);
        int hashCode = 0;
        for (int i = 0; i < 32; i++) {
            hashCode = i * HASH_INCREMENT;
            int bucket = hashCode & 31;
            System.out.println(i + " 在桶中位置： " + bucket);
        }
    }

}
