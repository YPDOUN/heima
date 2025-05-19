package IOStreamDemo.InputStreamDeom1;

import java.io.FileInputStream;
import java.io.IOException;
/*
 * read方法只能读一个字符(读一个就移动一次指针) 当读不到字符时会返回-1
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("IOStreamDemo\\a.txt");

        /*
         * 只能读一个，因此用循环读取
         * 1.先获取字符赋值给b b = fis.read()
         * 2.再判断是否为-1到文件结尾
         */
        int b;
        while((b = fis.read()) != -1){
            System.out.println((char)b);
        }

        fis.close();

    }
}
