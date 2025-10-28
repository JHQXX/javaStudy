package top.lovebegetslover.javase.xfg.juc;

public class LambdaThreadExample {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Lambda线程:" + i);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        //使用方法引用
        Thread t2 = new Thread(LambdaThreadExample::printNumbers);

        t1.start();
        t2.start();


    }

    public static void printNumbers() {
        for (int i = 0; i < 5; i++) {
            System.out.println("方法引用线程: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
