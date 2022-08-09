package baymax.singleton;

/**
 * @author zhanghongbing
 * @data 2022/8/3
 */
public class SingletonStaticClass {
    private SingletonStaticClass() {
    }
    private static class SingletonStaticInner{
        private final static SingletonStaticClass INSTANCE = new SingletonStaticClass();
    }

    public static SingletonStaticClass getInstance(){
        return SingletonStaticInner.INSTANCE;
    }
}
