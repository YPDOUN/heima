package IOStreamDemo.OutputStreamDemo1;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 字符输出流细节：
 *      1.创建字符输出流对象
 *          -参数是文件路径或者file对象都可以
 *          -每次创建且父级路径必须存在比如IOStreamDemo\IOStreamDemo1\aaa\a.txt aaa不存在则无法创建
 *          -文件如果存在则会清空文件再写入
 *      2.写数据
 *          -ASCII
 *      3.释放资源
 *          -不释放会占用资源
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("IOStreamDemo\\a.txt");

        fos.write(97);

        fos.close();
    }
}
