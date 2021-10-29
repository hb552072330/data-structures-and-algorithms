package cn.baymax.example.proxy;

/**
 * @author zhanghongbing
 * @data 2021/10/14
 */
public class SmsProxy implements ISmsService {
    private final ISmsService smsService;

    public SmsProxy(ISmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }
}
