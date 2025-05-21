package charstream.filereaderdemo2;

import java.io.FileReader;
import java.io.IOException;

/*
 * 字符数组读取数据：
 *      1. len用于存放read()返回的字符数
 *      2. char[] 用于存放一次性读入多少个字符
 *      FileReader 底层一般在内存会有一个缓冲区(大小为8192字节)，会先将字符文件按字节读入该缓冲区，再写入字符数组中
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileReader fr1 = new FileReader("charstream\\a.txt");

        int len;
        char[] chars = new char[5];

        while((len = fr1.read(chars)) != -1){
            //变为字符串再打印
            System.out.print(new String(chars, 0, len));
        }

        fr1.close();
    }
}
