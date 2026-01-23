package cn.jhqxx.concurrency._01volatile_test;


/**
 * @author jhqxx 梦想成为工程师的人
 * @date 2026/1/4 10:09
 * @description: Volatile保证线程共享变量(保证不同的核心之间共享变量)
 */
public class VolatileDemo {

    // ❌ 如果不加 volatile，main 线程改了值，t1 线程可能永远看不见
//     private static boolean stop = false;

    // ✅ 加上 volatile，t1 线程立马能感知到变化
    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        // 获取变量的哈希码
        int hashCode = System.identityHashCode(stop);
        // 转换为十六进制地址
        String hexAddress = Integer.toHexString(hashCode);
        Thread t1 = new Thread(() -> {
            System.out.println("t1 正在运行...");
            while (!stop) {
                // 如果没有 volatile，t1 会一直死循环
                // 因为它一直读的是自己工作内存里的旧值 (false)
            }
            System.out.println("t1 检测到停止信号，停车！");
        });

        t1.start();
        Thread.sleep(1000); // 让 t1 先跑一会儿

        System.out.println("main 线程修改 stop = true");
        stop = true; // 修改值
    }
}
