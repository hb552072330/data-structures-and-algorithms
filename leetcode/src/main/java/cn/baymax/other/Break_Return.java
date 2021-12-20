package cn.baymax.other;

/**
 * break|return test in for loop
 * @author zhanghongbing
 * @data 2021/7/2
 */
public class Break_Return {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                if (i == 3) {
                    break;//跳出当前循环，继续剩余循环
                }
                if (i == 5) {
                    return;//直接返回，循环不再继续
                }
                System.out.println(i);
            }
        }
    }
}
