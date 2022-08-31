package cn.baymax.example._thread;

/**
 * @author zhanghongbing
 * @data 2021/11/3
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}
//同步语句块的实现使用的是 monitorenter(line82) 和 monitorexit(line86) 指令，其中 monitorenter 指令指向同步代码块的开始位置,monitorexit 指令则指明同步代码块的结束位置

//Last modified 2022-7-27; size 674 bytes
//  MD5 checksum 45b9a4b3126fda89e900165ebabf0a78
//  Compiled from "SynchronizedDemo.java"
//public class cn.baymax.example._thread.SynchronizedDemo
//  minor version: 0
//  major version: 52
//  flags: ACC_PUBLIC, ACC_SUPER
//Constant pool:
//   #1 = Methodref          #6.#21         // java/lang/Object."<init>":()V
//   #2 = Fieldref           #22.#23        // java/lang/System.out:Ljava/io/PrintStream;
//   #3 = String             #24            // synchronized 代码块
//   #4 = Methodref          #25.#26        // java/io/PrintStream.println:(Ljava/lang/String;)V
//   #5 = Class              #27            // cn/baymax/example/_thread/SynchronizedDemo
//   #6 = Class              #28            // java/lang/Object
//   #7 = Utf8               <init>
//   #8 = Utf8               ()V
//   #9 = Utf8               Code
//  #10 = Utf8               LineNumberTable
//  #11 = Utf8               LocalVariableTable
//  #12 = Utf8               this
//  #13 = Utf8               Lcn/baymax/example/_thread/SynchronizedDemo;
//  #14 = Utf8               method
//  #15 = Utf8               StackMapTable
//  #16 = Class              #27            // cn/baymax/example/_thread/SynchronizedDemo
//  #17 = Class              #28            // java/lang/Object
//  #18 = Class              #29            // java/lang/Throwable
//  #19 = Utf8               SourceFile
//  #20 = Utf8               SynchronizedDemo.java
//  #21 = NameAndType        #7:#8          // "<init>":()V
//  #22 = Class              #30            // java/lang/System
//  #23 = NameAndType        #31:#32        // out:Ljava/io/PrintStream;
//  #24 = Utf8               synchronized 代码块
//  #25 = Class              #33            // java/io/PrintStream
//  #26 = NameAndType        #34:#35        // println:(Ljava/lang/String;)V
//  #27 = Utf8               cn/baymax/example/_thread/SynchronizedDemo
//  #28 = Utf8               java/lang/Object
//  #29 = Utf8               java/lang/Throwable
//  #30 = Utf8               java/lang/System
//  #31 = Utf8               out
//  #32 = Utf8               Ljava/io/PrintStream;
//  #33 = Utf8               java/io/PrintStream
//  #34 = Utf8               println
//  #35 = Utf8               (Ljava/lang/String;)V
//{
//  public cn.baymax.example._thread.SynchronizedDemo();
//    descriptor: ()V
//    flags: ACC_PUBLIC
//    Code:
//      stack=1, locals=1, args_size=1
//         0: aload_0
//         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//         4: return
//      LineNumberTable:
//        line 7: 0
//      LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//            0       5     0  this   Lcn/baymax/example/_thread/SynchronizedDemo;
//
//  public void method();
//    descriptor: ()V
//    flags: ACC_PUBLIC
//    Code:
//      stack=2, locals=3, args_size=1
//         0: aload_0
//         1: dup
//         2: astore_1
//         3: monitorenter
//         4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
//         7: ldc           #3                  // String synchronized 代码块
//         9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//        12: aload_1
//        13: monitorexit
//        14: goto          22
//        17: astore_2
//        18: aload_1
//        19: monitorexit
//        20: aload_2
//        21: athrow
//        22: return
//      Exception table:
//         from    to  target type
//             4    14    17   any
//            17    20    17   any
//      LineNumberTable:
//        line 9: 0
//        line 10: 4
//        line 11: 12
//        line 12: 22
//      LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//            0      23     0  this   Lcn/baymax/example/_thread/SynchronizedDemo;
//      StackMapTable: number_of_entries = 2
//        frame_type = 255 /* full_frame */
//          offset_delta = 17
//          locals = [ class cn/baymax/example/_thread/SynchronizedDemo, class java/lang/Object ]
//          stack = [ class java/lang/Throwable ]
//        frame_type = 250 /* chop */
//          offset_delta = 4
//}