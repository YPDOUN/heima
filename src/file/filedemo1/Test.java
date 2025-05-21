package file.filedemo1;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        //多种初始化方法
        String path1 = "D:\\Code\\Java-Code\\heima\\src\\file\\a.txt";

        File file1 = new File(path1);
        System.out.println(file1);

        String parent = "D:\\Code\\Java-Code\\heima\\src\\file";
        String child = "a.txt";
        File file2 = new File(parent, child);
        System.out.println(file2);
    }
}
