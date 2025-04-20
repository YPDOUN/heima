package SwitchDemo;
/*
    switch->表达式(仅可在java14+及以上使用)
    1.switch可做返回值
    2.case执行多行代码可使用{}代码块，并用yield返回值
 */

import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字：");
        int day = sc.nextInt();

        System.out.println(demo1(day));

        System.out.println("请输入数字：");
        day = sc.nextInt();
        System.out.println(demo2(day));
    }


    public static String demo1(int day){
        String dayname = switch(day){
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            default -> "Invalid";
        };

        return dayname;
    }

    public static String demo2(int day){
        String dayname = switch(day){
            case 1 -> {
                System.out.println("Processing Monday...");
                yield "Monday";
            }
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            default -> "Invalid";
        };

        return dayname;
    }
}