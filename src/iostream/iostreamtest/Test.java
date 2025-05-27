package iostream.iostreamtest;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        File src = new File("D:\\Code\\Java-Code\\heima\\src\\iostream\\files");
        File dest = new File("D:\\Code\\Java-Code\\heima\\src\\iostream\\copyfiles");

        copyFiles(src, dest);
    }

    /*
     *  src表示最外层文件夹 dest表示目标文件夹
     *  dest不存在则mkdir创建一个文件夹
     *  listFiles() 获取所有文件夹和文件
     *  从第一个文件开始判断 是文件则copy 不是则为文件夹再递归传入copyFiles拷贝该目录下的文件
     */
    private static void copyFiles(File src, File dest) throws IOException {
        dest.mkdir();

        File[] files = src.listFiles();

        for(File file : files){
            if (file.isFile()) {
                //file打开当前文件路径
                FileInputStream fis = new FileInputStream(file);
                //如果单纯为 new FileOutputStream(dest)打开的就不是文件而是文件夹
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));

                byte[] buf = new byte[1024];
                int len;

                while((len = fis.read(buf)) != -1){
                    fos.write(buf, 0, len);
                }

                fos.close();
                fis.close();
            }else{
                copyFiles(file, new File(dest, file.getName()));
            }
        }
    }
}
