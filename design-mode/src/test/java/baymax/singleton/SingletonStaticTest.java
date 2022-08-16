package baymax.singleton;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2022/8/3
 */
public class SingletonStaticTest extends TestCase {

    public void testGetInstance() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(SingletonStatic.getInstance().hashCode())).run();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(SingletonEnum.INSTANCE.hashCode())).run();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(SingletonSync.getInstance().hashCode())).run();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(SingletonStaticClass.getInstance().hashCode())).run();
        }
    }
}