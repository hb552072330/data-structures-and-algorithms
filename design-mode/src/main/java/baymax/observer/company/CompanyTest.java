package baymax.observer.company;

/**
 * @author zhanghongbing
 * @data 2022/8/8
 */
public class CompanyTest {
    public static void main(String[] args) {
        NBAObserver nbaObserver =new NBAObserver("张四");
        StockObserver stockObserver = new StockObserver("王五");
        Boss boss = new Boss();
        boss.addObserver(nbaObserver);
        boss.addObserver(stockObserver);
        boss.com();
        Secretary secretary = new Secretary();
        secretary.addObserver(nbaObserver);
        secretary.addObserver(stockObserver);
        secretary.see();
    }
}
