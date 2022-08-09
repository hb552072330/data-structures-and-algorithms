package cn.baymax.structure;

import cn.hutool.bloomfilter.BitSetBloomFilter;
import cn.hutool.bloomfilter.BloomFilterUtil;

import java.util.UUID;

/**
 * @author zhanghongbing
 * @data 2022/4/6
 */
public class HutoolBloomFilter {
    public static void main(String[] args) {
        BitSetBloomFilter bitSet = BloomFilterUtil.createBitSet(2000, 55, 55);
        System.out.println(bitSet.contains("123"));
        System.out.println(bitSet.contains("321"));
        bitSet.add("123");
        bitSet.add("321");
        System.out.println(bitSet.contains("123"));
        System.out.println(bitSet.contains("321"));
        System.out.println("------------------");
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());

    }
}
