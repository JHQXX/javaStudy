package top.lovebegetslover.javaee.reflect;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Lee
 * @Description: 用于联系反射有关知识
 * @DateTime: 2025/11/13 下午4:20
 **/
@Slf4j
public class ReflectionBasic {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionBasic.class);

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //获取Class 对象的三种方式
        log.info("根据类名： \t" + User.class);
        log.info("根据对象： \t" + new User().getClass());
        log.info("根据全限定类名 \t"+ Class.forName("top.lovebegetslover.javaee.reflect.User"));

        //常用方法
        log.info("获取全限定类名：\t" + User.class.getName());
        log.info("获取类名：\t" + User.class.getSimpleName());
        log.info("实例化：\t" + User.class.newInstance());


        /*Constructor 对象使用*/

        Class<?> clazz = null;

        //获取Class对象的引用
        clazz=Class.forName("top.lovebegetslover.javaee.reflect.User");

        //第一种方法 , 实例化默认构造方法 User必须无参构造器，否则将抛异常
        User user = (User) clazz.newInstance();
        user.setAge(20);
        user.setName("Lee");
        System.out.println(user.toString());
        System.out.println("------------------------------------------------------");

        //获取带String参数的public构造函数 这里必须使用参数的类
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        //创建User 对象
        User user1 = (User) constructor.newInstance("Lee", 18);
        user1.setName("Bob");
        user1.setAge(19);
        System.out.println("user1 : " +user1.toString());
        System.out.println("------------------------------------------------------");

        //获取私有构造函数
        Constructor<?> constructor2 = clazz.getDeclaredConstructor(String.class);
        //由于方法时私有的，需要设置 accessible 为 true
        constructor2.setAccessible(true);
        //创建User 对象
        User user2 = (User) constructor2.newInstance("Lee");
        user2.setName("jack");
        user2.setAge(199);
        System.out.println("user2 : " +user2.toString());
        System.out.println("------------------------------------------------------");

        //获取所有构造包含private
        Constructor<?>[] cons = clazz.getDeclaredConstructors();
        //查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            //获取构造函数的参数类型
            Class<?>[] clazzs = cons[i].getParameterTypes();
            System.out.println("构造函数" + i + ":" + cons[i].toString());
            System.out.println("参数类型["+i + "]:(");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length-1){
                    System.out.println(clazzs[j].getName());
                }else {
                    System.out.println(clazzs[j].getName() + ",");
                }
            }
            System.out.println(")");


        }

        /*Field 对象使用*/




    }

}


