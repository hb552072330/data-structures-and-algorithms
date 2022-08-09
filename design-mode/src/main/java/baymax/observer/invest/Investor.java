package baymax.observer.invest;

/**
 * @author zhanghongbing
 * @data 2022/8/8
 */
public class Investor implements IInvest {
    private String name;
    private Stock stock;

    public Investor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void update(Stock stock) {
        System.out.println(name+" "+stock.symbol+" "+stock.price);
    }
}
