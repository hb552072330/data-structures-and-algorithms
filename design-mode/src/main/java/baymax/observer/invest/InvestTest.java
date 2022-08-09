package baymax.observer.invest;

/**
 * @author zhanghongbing
 * @data 2022/8/9
 */
public class InvestTest {
    public static void main(String[] args) {
        Investor zhangsan = new Investor("张三");
        Investor lisi = new Investor("李四");
        Stock qq = new QQ("深圳腾讯", 121.1);
        qq.Attach(zhangsan);
        qq.Attach(lisi);
        qq.setPrice(111.1);
        qq.setPrice(112.1);
        qq.Detach(lisi);
        qq.setPrice(333.2);
    }
}
