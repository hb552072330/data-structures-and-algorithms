package cn.baymax.example.proxy;

/**
 * @author zhanghongbing
 * @data 2021/10/14
 */
public class ProxyDynamicTest {
    public static void main(String[] args) {
        ISmsService smsService = (ISmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java JDK");
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java CGLIB");
    }
}
