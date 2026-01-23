package cn.jhqxx.concurrency._02synchronized_test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jhqxx 梦想成为工程师的人
 * @date 2026/1/21 13:09
 * @description: 锁实例方法
 */
public  class _00method_synchronized {

    private static int i = 0;
    private static int k = 0;

    synchronized static void  inc(){
        i++;
    }
    public static void ink(){
        k++;
    }


    public static void main(String[] args) throws InterruptedException {
        //创建对象
//        _00method_synchronized methodSynchronized = new _00method_synchronized();
        //使用该对象的方法
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            threadPool.execute(()->{
                try {
                    for (int j = 0; j < 10000000; j++) {
                        inc();
                        ink();
                    }
                } finally {
                    countDownLatch.countDown();;
                }
            });
        }
        //主线程等待，直到计数器归零
        countDownLatch.await();

        System.out.println(i);
        System.out.println(k);

        //
        threadPool.shutdown();

    }
}
