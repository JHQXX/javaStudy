package top.lovebegetslover.javase.runoob;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflectionTest {

//    public static void main(String[] args) throws Exception{
//        //如何获取Class对象
//        //通过类字面量
//        Class<?> clazz = String.class;
//        //通过对象实例
//        String str = "你好";
//        Class<? extends String> aClass = str.getClass();
//        //通过Class.forName()方法
//
//        Class<?> clazz3 = Class.forName("java.lang.String");
//
//        //通过反射来创建对象
//        Class<?> aClass4 = Class.forName("java.lang.String");
//        String obj = (String)aClass4.getDeclaredConstructor().newInstance();
//
//        //访问字段
//        Class<Persson> perssonClass = Persson.class;
//        Persson persson1 = perssonClass.getDeclaredConstructor(String.class,String.class,Integer.class).newInstance("小A","小B",30);
//
//        Persson persson = new Persson("打狗", "母狗", 20);
//        Field name = perssonClass.getDeclaredField("name");
////        name.setAccessible(true);//如果字段是私有的，需要设置为可访问 由于这里name本身就是共有的，就不用设置了
//        //获取字段值 我可以理解，可以 通过这个方法获取所有实例对象中的某一个值作为监管 但是你得传入实例对象啊
//        //第一 我们可以直接创建对象
////        String name1 = persson.getName();
//        Object value = name.get(persson);
//        Object value1 = name.get(persson1);
//
//        name.set(persson,"李志");//设置字段值 给第一个对象
//        name.set(persson1,"大傻瓜");//设置字段值  给第二个对象
//
//        Object value3 = name.get(persson);//再次获取
//        Object value4 = name.get(persson1);//再次获取
//
//
//        System.out.println(value3);//打印
//        System.out.println(value4);//打印
//    }

}


class TesTB{
    public static void main(String[] args) throws Exception {
        //反射获取方法


        Class<Persson> perssonClass = Persson.class;
        //不用实例化对象也能拿取方法
        Method method1 = perssonClass.getMethod("publicModel",Integer.class);
        //获取对象
        Persson persson1 = perssonClass.getDeclaredConstructor(String.class,String.class,Integer.class).newInstance("小A","小B",30);
        Field value = perssonClass.getDeclaredField("value");
        value.setAccessible(true);
        Integer o = (Integer) value.get(persson1);
        System.out.println(o);
        //执行
        method1.invoke(persson1,10);
        //访问这个参数
        //1.直接访问--没有办法修改 但是得有对应的构造方法
        //2.反射方法
        Integer o2 = (Integer) value.get(persson1);
        System.out.println(o2);

    }
}

class TestC{
    public static void main(String[] args) throws Exception {
        Class<Persson> perssonClass = Persson.class;
        //构造器
        Constructor<Persson> constructor = perssonClass.getConstructor(String.class, String.class, Integer.class);
        Constructor<Persson> constructor2 = perssonClass.getConstructor();
        //通过构造器构造
        Persson persson = constructor.newInstance("小明", "校址", 190);
    }
}

class TestD{
    public static void main(String[] args) throws Exception  {
        Class<Persson> perssonClass = Persson.class;
        Constructor<Persson> constructor2 = perssonClass.getConstructor();
        Persson persson = constructor2.newInstance();
        //获取接口
        Class<?>[] interfaces = perssonClass.getInterfaces();
        //拿取所有的接口
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口名称"+anInterface.getName());
        }
        //获取父类接口
        Class<action> actionClass = action.class;
        Class<?>[] interfaces1 = actionClass.getInterfaces();
        for (Class<?> anInterface : interfaces1) {
            System.out.println("superclassName:"+anInterface.getName());
        }
        //获取父类--这个方法只能拿取类
        Class<? super Persson> superclass = perssonClass.getSuperclass();

    }
}

class MaximumTest
{
    // 比较三个值并返回最大值
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }
    public static void main( String args[] )
    {

        A a = new A();
        B b = new B();
        B b1 = new B();
        B b2 = new B();
//        Comparable maximum = maximum(a, b1, b2);
        Comparable maximum = maximum(b, b1, b2);


        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
                "apple", "orange", maximum( "pear", "apple", "orange" ) );
    }
}

class A implements Comparable<A>{
    private int a;

    @Override
    public int compareTo(A o) {
        //我这个对象是如何进行比较的
        return 0;
    }
}

class B implements Comparable<B>{
    private int a;

    @Override
    public int compareTo(B o) {
        //我这个对象是如何进行比较的
        return 0;
    }
}


class Box<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}



