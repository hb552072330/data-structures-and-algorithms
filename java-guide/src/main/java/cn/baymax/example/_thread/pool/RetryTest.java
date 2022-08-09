package cn.baymax.example._thread.pool;

/**
 * @author zhanghongbing
 * @data 2021/11/10
 */
public class RetryTest {
    /*retry就是一个标记，标记对一个循环方法的操作continue/break处理点，功能类似于goto，所以retry一般都是伴随着for循环出现；
    retry标记的下一行就是for循环，在for循环里面调用continue/break再紧接着retry标记时，就表示从这个地方开始执行continue/break操作；
    continue+retry的效果与break相同；
    我们可以不用retry，可以使用任何合法字符来代替retry，比如上面示例中用“muse”来代替“retry”。
    */
    public static void main(String[] args) {
        testContinue();
        System.out.println("`````````````````````````````");
        testContinue0();
        System.out.println("`````````````````````````````");
        testContinue2();
        System.out.println("`````````````````````````````");
        testContinue3();
    }

    public static void testContinue() {
        retry:
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    break;
                }
                System.out.print("[" + j + ", " + i + "],");
            }
        }
        System.out.print(" >>> OK");
    }

    public static void testContinue0() {
        retry:
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    continue retry;
                }
                System.out.print("[" + j + ", " + i + "],");
            }
        }
        System.out.print(" >>> OK");
    }

    public static void testContinue3() {
        muse:
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    break muse;
                }
                System.out.print("[" + j + ", " + i + "],");
            }

        }
        System.out.print(" >>> OK");
    }

    public static void testContinue2() {
        muse:
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 5; j++) {
                System.out.print(j + ", ");
                if (j == 3) {
                    break muse;
                }
            }
        }
        System.out.print(" >>> OK");
    }
}
