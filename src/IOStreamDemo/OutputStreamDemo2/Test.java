package IOStreamDemo.OutputStreamDemo2;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 *      用byte[]数组连续写入数据
 *      用\r\n写入换行符
 *      输入输出流对象形参初始化可以设置append追加
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //创建字节流对象
        FileOutputStream ofs = new FileOutputStream("IOStreamDemo\\a.txt", true);

        //写入数据
        String s1 = "李华三好学生";
        byte[] bytes1 = s1.getBytes();
        ofs.write(bytes1);

        String s2 = "\r\n";
        byte[] bytes2 = s2.getBytes();
        ofs.write(bytes2);

        String s3 = "abcdefg";
        byte[] bytes3 = s3.getBytes();
        ofs.write(bytes3);
        //关闭文件
        ofs.close();
    }
}
