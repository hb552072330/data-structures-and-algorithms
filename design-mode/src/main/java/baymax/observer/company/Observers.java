package baymax.observer.company;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zhanghongbing
 * @data 2022/8/8
 */
public abstract class Observers implements Observer {

    protected String name;

    public Observers(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public abstract void update(Observable o, Object arg);

    public abstract void see();
    public abstract void exit();
    public abstract void criticize();

}
