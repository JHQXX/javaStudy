package cn.jhqxx.concurrency;

/**
 * @author jhqxx 梦想成为工程师的人
 * @date 2026/1/7 22:01
 * @description: 测试
 */
public class test {
    public static void main(String[] args) {
        String key = "";
        for (int i = 0; i < 10; i++) {
            int random  = (int) (Math.random() * (10 + 1));
            System.out.println(random);
        }
    }
}
