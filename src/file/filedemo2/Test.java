package file.filedemo2;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File f1 = new File("D:\\Code\\Java-Code\\heima\\src\\file\\a.txt");

        System.out.println(f1.isDirectory());//判断是否为文件夹
        System.out.println(f1.isFile());//判断是否为文件
        System.out.println(f1.exists());//判断是否存在
        System.out.println(f1.length());//文件大小

    }
}
