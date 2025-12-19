package other;

import java.util.*;

/**
 * @author zhanghongbing
 * @data 2022/10/10
 */
public class Test {
    public static void main(String[] args) {
//        Map<Integer, List<Long>> map = new HashMap<>();
//        for (int i = 0; i < 10; i++) {
//            if ((i % 2) == 0) {
//                List<Long> orDefault = map.getOrDefault(0, new ArrayList<>());
//                orDefault.add((long)i);
//                map.put(0, orDefault);
//            }
//        }
//        System.out.println(map);

        ArrayList<Integer> list = new ArrayList<Integer>() {{
            add(222);
            add(-233);
            add(32);
            add(52);
            add(32);
        }};
        System.out.println(list);
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
        list.sort((Integer o1, Integer o2) -> o1 - o2);
        System.out.println(list);
        System.out.println("-----");
        System.out.println(getIdempotentId());

    }
    private static String getIdempotentId() {
        Integer random = 0;
        do {
            random = (int) (Math.random() * 100000);
        } while (random < 10000);
        return System.currentTimeMillis() + "-" + random;
    }
}
