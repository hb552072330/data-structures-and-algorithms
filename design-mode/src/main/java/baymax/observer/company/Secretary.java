package baymax.observer.company;

import java.util.Observable;

/**
 * @author zhanghongbing
 * @data 2022/8/5
 */
public class Secretary extends Observable {
    private int state = 0;//离开
    public void see() {
        System.out.println("老板回来了");
        state=1;//老板回来啦
        setChanged();
        notifyObservers(state);
    }

}
