package baymax.observer.invest;

import java.util.ArrayList;

/**
 * @author zhanghongbing
 * @data 2022/8/8
 */
public class Stock {
    protected String symbol;
    protected double price;
    private ArrayList<Investor> investors = new ArrayList<>();

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyInvestor();
    }

    public void Attach(Investor investor) {
        investors.add(investor);
    }

    public void Detach(Investor investor) {
        investors.remove(investor);
    }

    public void notifyInvestor() {
        for (Investor investor : investors) {
            investor.update(this);
        }
    }

}
