package class05;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhanghongbing
 * @data 2022/9/6
 */
public class Code02BitMapError {
    public static class BitMap {
        private long[] bits;

        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];//1000 000 (max+64)/32
        }

        public void add(int num) {
            // num & 63 等同于 num % 64
            // num >> 6 等同于 num / 32
            // long 长整形 4字节  4*8 32
            // |  有1  返回 1
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num) {
            bits[num >> 6] &= ~(1 << (num & 63));
        }

        public boolean constains(int num) {
            return (bits[num >> 6] & (1 << (num & 63))) != 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        int testTime = 10000000;
        int max = 50000;
        BitMap bitMap = new BitMap(max);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * max);
            double decide = Math.random();
            if (decide < 0.33) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.66) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.constains(num) != set.contains(num)) {
                    System.out.println("Ooops");
                    break;
                }
            }
        }
        System.out.println(set.size());
        for (int i = 0; i < max; i++) {
            if (bitMap.constains(i) != set.contains(i)) {
                System.out.println("Ooops");
                break;
            }
        }
        System.out.println("test end");
    }
}
