package iostream.appofiostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  利用字节数组存放读入的多个字节的数据
 *  核心：fis.read(byte[] a)会返回从文件中读取的字节总数
 *       当文件所要读入的字节数大于数组长度 则分批读入返回的就是当前数组长度
 *       否则则返回读取字节数 当读完了返回-1
 *  因此在内存允许的条件下可以调整数组容量，使其尽可能读入多的字节，实现快速读写
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("IOStream\\a.txt");
//        FileOutputStream fos = new FileOutputStream("IOStream\\b.txt");
        FileInputStream fis = new FileInputStream("IOStream\\mysql.msi");
        FileOutputStream fos = new FileOutputStream("IOStream\\myCopy.msi");

        byte[] buffer = new byte[1024 * 1024 * 5];
        int len;//获取读入数组的字节数

        //len = fis.read(buffer) 读入了多少字节，同时下一次读入会覆盖掉之前的数据
        while((len = fis.read(buffer)) != -1){
            fos.write(buffer, 0, len);//上面读多少下面下多少
        }

        fos.close();
    }
}
