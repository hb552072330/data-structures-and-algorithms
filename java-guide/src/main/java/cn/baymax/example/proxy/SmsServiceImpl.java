package cn.baymax.example.proxy;

/**
 * @author zhanghongbing
 * @data 2021/10/14
 */
public class SmsServiceImpl implements ISmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
