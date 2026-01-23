package cn.jhqxx.concurrency._02synchronized_test;

/**
 * @author jhqxx 梦想成为工程师的人
 * @date 2026/1/21 21:12
 * @description: Synchronized-jvm底层
 */
public class _01SynchronizedDemo {



    public void method(){
        synchronized (this){
            System.out.println("synchronized 代码块");
        }
    }

    synchronized  void synchronizedMethode(){
        System.out.println("synchronizedMethode");
    }

    synchronized  static  void  staticMethode(){
        System.out.println("staticMethode");
    }

}
