package charstream.filereaderdemo1;

import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("charstream\\a.txt");
        /* 字符流底层也是字节流
         * read()也是按字节读的，只不过遇到了中文字符就读三个字节
         * 读取后会将一个字节转为10进制
         *
         */
        int ch;
        while((ch = fr.read()) != -1){
            System.out.print(ch + " ");
        }
        fr.close();
    }
}
