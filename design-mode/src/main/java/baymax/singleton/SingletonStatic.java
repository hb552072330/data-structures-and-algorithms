package baymax.singleton;

/**
 * @author zhanghongbing
 * @data 2022/8/3
 */
public class SingletonStatic {
    private SingletonStatic() {
    }

    private final static SingletonStatic instance = new SingletonStatic();

    public static SingletonStatic getInstance() {
        return instance;
    }
}
