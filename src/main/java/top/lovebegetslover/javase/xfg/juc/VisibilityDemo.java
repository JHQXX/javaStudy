package top.lovebegetslover.javase.xfg.juc;

public class VisibilityDemo {
    //可见性--线程
    private boolean flag = false;

    public void writer() {
        flag = true; // 线程1修改
    }

    public void reader() {
        while (!flag) {
            // 线程2可能永远看不到flag的修改
        }
        System.out.println("Flag is true!");
    }

    public static void main(String[] args) {
        //直接创建
        Thread th1 = new Thread();
        //创建的时候赋值
        new Thread("th2");
        //创建的时候直接创建任务--没有返回值
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });


    }
}
