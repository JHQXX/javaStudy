package top.lovebegetslover.javase.chapter05_array.src.com.atguigu1.one.exer2;


import java.util.Scanner;

/**
 * @Author: Lee
 * @Description: 翻译数组
 * @DateTime: 2025/9/9 上午11:22
 **/
public class ArrayExerEnglishTranslation {
    public static void main(String[] args) {
        boolean isT=true;
        while (isT){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请选择月份还是星期：M / W");
            String chose = scanner.nextLine();
            if (chose.equals("M") || chose.equals("m")){
                System.out.println("请输入数字1-12");
                String monthEnglishTranslation = getMonthEnglishTranslation(scanner);
                if (!monthEnglishTranslation.equals("未找到对应的月份")){
                    isT=false;
                }
                System.out.println(monthEnglishTranslation);
            }else {
                System.out.println("请输入数字1-7");
                //根据传入的数字来做判断
                String weekEnglishTranslation = getWeekEnglishTranslation(scanner);
                if (!weekEnglishTranslation.equals("未找到对应的星期")){
                    isT=false;
                }
                System.out.println(weekEnglishTranslation);
            }
        }


    }

    public static String getWeekEnglishTranslation(Scanner scanner){
        //创建数组来存储周一到周日的单词
        String[] weeks={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        if (scanner.hasNextInt()){
            int i = scanner.nextInt();
            return weeks[i-1];
        }else {
            System.out.println("请输入正确的数字数字1-7");
            return "未找到对应的星期";
        }

    }

    public static String getMonthEnglishTranslation(Scanner scanner){
        //创建数组来存储周一到周日的单词
        String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
        if (scanner.hasNextInt()){
            int i = scanner.nextInt();
            return months[i-1];
        }else {
            System.out.println("请输入正确的数字数字1-12");
            return "未找到对应的月份";
        }

    }
}
