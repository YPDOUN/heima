package StringDemo;

import java.util.Scanner;

/*
        String创建方式有两种：
        1.直接赋值 String s = "abc";
          abc会被存储在字符串常量池 比较两个串池创建的字符串是相等的
        2.new创建字符串 String s = new String("abc");
          此时会在堆内存创建一个String对象 s是引用存储地址 比较两个new出的字符串是不等的
        new出的字符串比较需要用到equal()方法

        charAt(index)用于获取字符串指定索引位置的字符
        substring()用于截取子串 截取原则是左包右不包 [1,5)：截取 1-4 当只有一个参数时截取到末尾
 */
public class Test {
    public static void main(String[] args) {
        //1.输入字符串并遍历
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符：");
        String s = sc.next();
        printChar(s);

    }

    public static void printChar(String str){
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }
}
