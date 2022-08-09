package baymax.singleton;

/**
 * @author zhanghongbing
 * @data 2022/8/3
 */
public class SingletonSync {
    private volatile static SingletonSync singletonSync;

    private SingletonSync() {
    }

    public static SingletonSync getInstance(){
        if(singletonSync == null) {
            synchronized (SingletonStatic.class){
                if(singletonSync == null){
                    singletonSync = new SingletonSync();
                }
            }
        }
        return singletonSync;
    }
}
