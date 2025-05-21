package charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
 * 中文常见编码方式：GBK和 UTF-8
 * 编码标准：GBK和 Unicode
 * GBK是2字节表示一个汉字  Unicode是3字节表示一个汉字
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "abc李华";

        //编码
        byte[] bytes1 = str.getBytes("UTF-8");
        System.out.println(Arrays.toString(bytes1));//[97, 98, 99, -26, -99, -114, -27, -115, -114]

        byte[] bytes2 = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));

        //解码
        String str1 = new String(bytes1);
        System.out.println(str1);

        String str2 = new String(bytes1, "GBK");
        System.out.println(str2);
    }
}
