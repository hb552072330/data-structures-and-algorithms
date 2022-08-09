package baymax.observer.company;

import java.util.Observable;

/**
 * @author zhanghongbing
 * @data 2022/8/5
 */
public class Boss extends Observable {
    private int state = 0;//离开

    public void com() {
        System.out.println("我大老板回来了");
        state = 2;//回来
        setChanged();//必须要写
        notifyObservers(state);//发出通知

    }

}
