package cn.jhqxx.concurrency._01volatile_test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jhqxx 梦想成为工程师的人
 * @date 2026/1/19 21:19
 * @description: volatile不可保证其原子性
 */
public class VolatileAtomicityDemo {

    public volatile static int inc = 0;

    public void increase() {
        inc++;
    }
    public static void main(String[] args) throws InterruptedException {
        //创建5个线程
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        VolatileAtomicityDemo volatileAtomicityDemo = new VolatileAtomicityDemo();
        for (int i = 0; i < 20; i++) {
            threadPool.execute(()->{
                for (int j = 0; j < 10000; j++) {
                    //开启20个线程进行执行
                    //不安全 小于 2-----
//                    volatileAtomicityDemo.increase();
                    //安全
                    volatileAtomicityDemo.increaseSync();
                    volatileAtomicityDemo.increaseAtomic();
                    volatileAtomicityDemo.increaseLock();

                }
            });
        }
        Thread.sleep(1500);
        System.out.println(inc);
        System.out.println(inc);
        System.out.println(volatileAtomicityDemo.getIncc());
        threadPool.shutdown();
    }

    //上吗是线程不安全的 -- 下面是安全的写法
    //synchronized
    public synchronized void increaseSync(){
        inc++;
    }
    //AtomicInteger -- 线程安全的int
    public AtomicInteger incc = new AtomicInteger();
    public void increaseAtomic(){
        incc.getAndIncrement();
    }
    public int getIncc(){
       return incc.get();
    }
    //ReentrantLock
    Lock lock = new ReentrantLock();
    public void increaseLock(){
        //拿取锁
        lock.lock();
        try {
            inc++;
        }finally {
            lock.unlock();
        }

    }

}
