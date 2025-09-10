package top.lovebegetslover.javase.chapter05_array.src.com.atguigu1.one.exer3;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 学习到的
    * 1 数组的创建从一开始就是有大小的
 */
public class ArrayExerStudentLeve {
    public static void main(String[] args) {
        //创建对应的等级
        String[] leve={"A","B","C","D"};
        //系统读取

        //输入学生的成绩，那么成绩是否是有一个对应人？有，那么这个成绩应该是一个对象
        boolean isT=true;
        //循环
        while (isT){
            System.out.println("是否导入学生成绩 Y / N");
            Scanner scannerY = new Scanner(System.in);
            if (scannerY.nextLine().equals("Y") || scannerY.nextLine().equals("YES") || scannerY.nextLine().equals("y")){
                System.out.println("请输入学生人数：");
                Scanner scannerNumber = new Scanner(System.in);
                int number = scannerNumber.nextInt();
                //创建学生数组
                student[] students = new student[number];
                //然后输入对应的学生名称和成绩
                for (int i = 0; i < number; i++) {
                    //对于对象的数组，初始化时候没有填充对象，而是声明的空间大小，则对应的空间内是没有对象引用的
                    students[i] = new student();
                    //输入
                    System.out.println("请输入学生姓名：");
                    Scanner scannerName = new Scanner(System.in);
                    String name = scannerName.nextLine();
                    System.out.println("请输入学生成绩：");
                    Scanner scannerGrades = new Scanner(System.in);
                    BigDecimal bigDecimal = scannerGrades.nextBigDecimal();
                    students[i].setName(name);
                    students[i].setGrades(bigDecimal);
                }
                //寻找出最好的成绩--并对其成绩打分
                //创建变量来存储最高分的数据
                BigDecimal maxGrade=BigDecimal.ONE;
                for (top.lovebegetslover.javase.chapter05_array.src.com.atguigu1.one.exer3.student student : students) {
                    if (student.getGrades().compareTo(maxGrade) > 0) {
                        maxGrade = student.getGrades();
                    }
                }
                //拿去了最高成绩，输出最高分 这里可以找到对应的童靴
                System.out.println("最高分为"+maxGrade);
                //拿取等级
                for (top.lovebegetslover.javase.chapter05_array.src.com.atguigu1.one.exer3.student student : students) {
                    if (student.getGrades().compareTo(maxGrade.abs().subtract(BigDecimal.TEN))>=0){
                        System.out.println("学生："+student.getName()+"成绩:"+student.getGrades()+"为等级A");
                    }else if (student.getGrades().compareTo(maxGrade.abs().subtract(BigDecimal.valueOf(20)))>=0){
                        System.out.println("学生："+student.getName()+"成绩:"+student.getGrades()+"为等级B");
                    }else if (student.getGrades().compareTo(maxGrade.abs().subtract(BigDecimal.valueOf(30)))>=0){
                        System.out.println("学生："+student.getName()+"成绩:"+student.getGrades()+"为等级C");
                    }else{
                        System.out.println("学生："+student.getName()+"成绩:"+student.getGrades()+"为等级D");
                    }
                }
            }else {
                //结束循环
                isT=false;
            }
        }

    }
}

class student{
    String name;
    BigDecimal grades;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getGrades() {
        return grades;
    }

    public void setGrades(BigDecimal grades) {
        this.grades = grades;
    }

}
