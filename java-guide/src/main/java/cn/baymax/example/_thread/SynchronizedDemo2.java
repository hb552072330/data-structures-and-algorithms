package cn.baymax.example._thread;

/**
 * @author zhanghongbing
 * @data 2021/11/3
 */
public class SynchronizedDemo2 {
    public synchronized void method() {
        System.out.println("synchronized 方法");
    }
}
//synchronized 修饰的方法并没有 monitorenter 指令和 monitorexit 指令，取得代之的确实是 ACC_SYNCHRONIZED 标识，该标识指明了该方法是一个同步方法。(line 68)
//Last modified 2022-7-27; size 562 bytes
//  MD5 checksum f59d4b9382adea0c91614fdc4fb89812
//  Compiled from "SynchronizedDemo2.java"
//public class cn.baymax.example._thread.SynchronizedDemo2
//  minor version: 0
//  major version: 52
//  flags: ACC_PUBLIC, ACC_SUPER
//Constant pool:
//   #1 = Methodref          #6.#17         // java/lang/Object."<init>":()V
//   #2 = Fieldref           #18.#19        // java/lang/System.out:Ljava/io/PrintStream;
//   #3 = String             #20            // synchronized 方法
//   #4 = Methodref          #21.#22        // java/io/PrintStream.println:(Ljava/lang/String;)V
//   #5 = Class              #23            // cn/baymax/example/_thread/SynchronizedDemo2
//   #6 = Class              #24            // java/lang/Object
//   #7 = Utf8               <init>
//   #8 = Utf8               ()V
//   #9 = Utf8               Code
//  #10 = Utf8               LineNumberTable
//  #11 = Utf8               LocalVariableTable
//  #12 = Utf8               this
//  #13 = Utf8               Lcn/baymax/example/_thread/SynchronizedDemo2;
//  #14 = Utf8               method
//  #15 = Utf8               SourceFile
//  #16 = Utf8               SynchronizedDemo2.java
//  #17 = NameAndType        #7:#8          // "<init>":()V
//  #18 = Class              #25            // java/lang/System
//  #19 = NameAndType        #26:#27        // out:Ljava/io/PrintStream;
//  #20 = Utf8               synchronized 方法
//  #21 = Class              #28            // java/io/PrintStream
//  #22 = NameAndType        #29:#30        // println:(Ljava/lang/String;)V
//  #23 = Utf8               cn/baymax/example/_thread/SynchronizedDemo2
//  #24 = Utf8               java/lang/Object
//  #25 = Utf8               java/lang/System
//  #26 = Utf8               out
//  #27 = Utf8               Ljava/io/PrintStream;
//  #28 = Utf8               java/io/PrintStream
//  #29 = Utf8               println
//  #30 = Utf8               (Ljava/lang/String;)V
//{
//  public cn.baymax.example._thread.SynchronizedDemo2();
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
//            0       5     0  this   Lcn/baymax/example/_thread/SynchronizedDemo2;
//
//  public synchronized void method();
//    descriptor: ()V
//    flags: ACC_PUBLIC, ACC_SYNCHRONIZED
//    Code:
//      stack=2, locals=1, args_size=1
//         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
//         3: ldc           #3                  // String synchronized 方法
//         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//         8: return
//      LineNumberTable:
//        line 9: 0
//        line 10: 8
//      LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//            0       9     0  this   Lcn/baymax/example/_thread/SynchronizedDemo2;
//}