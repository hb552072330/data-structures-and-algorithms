package baymax.observer.clown;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zhanghongbing
 * @data 2022/8/5
 */
public class Viewer implements Observer {
    public Viewer(int id) {
        this.id = id;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer id = (Integer) arg;
        switch (id) {
            case Clown.good:
                applause();
                break;
            case Clown.complete:
                exit();
                break;
            case Clown.bad:
                cheerback();
                break;
        }

    }

    private void applause() {
        System.out.println(id + "号观众鼓掌了");
    }

    private void cheerback() {
        System.out.println(id + "号观众喝倒彩");
    }

    private void exit() {
        System.out.println(id + "号观众退场了");
    }
}
