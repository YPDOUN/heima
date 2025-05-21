package iostream.inputstreamdeom1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

        //文件拷贝  边读边写
        FileInputStream fis2 = new FileInputStream("IOStream\\a.txt");
        FileOutputStream fos = new FileOutputStream("填入要拷贝到的地方");
        int a;
        while((a = fis2.read()) != -1){
            fos.write(a);
        }
        fis2.close();
        fos.close();

    }
}
