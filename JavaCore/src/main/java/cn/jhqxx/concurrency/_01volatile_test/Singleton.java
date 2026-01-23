package cn.jhqxx.concurrency._01volatile_test;

/**
 * @author jhqxx 梦想成为工程师的人
 * @date 2026/1/19 21:12
 * @description: volatile防止指令重排
 */
public class Singleton {

//    public static void main(String[] args) {
//        new Unsafe();
//    }
    private static volatile Singleton uniqueInstance;


    public Singleton() {
    }

    public static Singleton getInstance(){
        //先判断对象是否已经实例过 ，没有直接枷锁
        if (uniqueInstance == null){
            //类对象枷锁
            synchronized (Singleton.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
