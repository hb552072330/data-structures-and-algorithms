package cn.baymax.example.proxy;

/**
 * @author zhanghongbing
 * @data 2021/10/14
 */
public class ProxyStaticTest {
    public static void main(String[] args) {
        ISmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }
}
