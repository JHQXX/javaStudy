package top.lovebegetslover.javase.xfg.juc;

public class ThreadStateExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            try {
                Thread.sleep(2000);
                //线程独立 主线程睡1s
                synchronized (ThreadStateExample.class){
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });


        System.out.println("创建后："+ thread.getState());

        thread.start();
        System.out.println("启动后："+ thread.getState());

        Thread.sleep(100);
        System.out.println("睡眠中"+ thread.getState());

        thread.join();
        System.out.println("结束后"+ thread.getState());
    }
}
