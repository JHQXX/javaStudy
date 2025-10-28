package top.lovebegetslover.javase.xfg.juc;

public class UnsafeCounter {
    private int count=0;

    public void increment(){
        //这不是原子操作
        count++;
    }

    //返回计数器
    private int getCount(){
        return count;
    }

    //main方法
    public static void main(String[] args) throws Exception {

        //创建对象
        UnsafeCounter unsafeCounter = new UnsafeCounter();
        //创建1000个线程，每个线程执行1000次increment方法
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(()->{
                //执行方法1000次
                for (int j = 0; j < 1000; j++) {
                    unsafeCounter.increment();
                }
            });
            //开始执行
            threads[i].start();
        }

        //等待所有的线程执行完成
        for (Thread thread : threads) {
            thread.join();
        }

        //期望结果 是 1000000 实际结果：小于1000000
        System.out.println("最终结果"+unsafeCounter.getCount());

    }


}
