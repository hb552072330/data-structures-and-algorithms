import java.util.HashMap;

/**
 * @Author zhanghongbing
 * @Date 2025-07-15 17:33
 **/
public class Test1 {
    public static void main(String[] args) {
        // 创建hashmap 放入null  并打印
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map);
        System.out.println(map.get(null));

    }
}
