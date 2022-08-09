package baymax.observer.company;

import java.util.Observable;

/**
 * @author zhanghongbing
 * @data 2022/8/8
 */
public class StockObserver extends Observers {

    public StockObserver(String name) {
        super(name);
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer state = (int) arg;
        switch (state) {
            case 0:
                see();
                break;
            case 1:
                exit();
                break;
            case 2:
                criticize();
                break;
        }
    }

    @Override
    public void see() {
        System.out.println(name + "看股票");
    }

    @Override
    public void exit() {
        System.out.println(name + "停止看股票，开始工作");
    }

    @Override
    public void criticize() {
        System.out.println(name + "你居然在工作时间看股票，快工作！");
    }
}
