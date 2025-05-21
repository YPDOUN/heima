package charstream.filewriterdemo;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 父级路径存在自动创建文件
 *  打开即清空文件，append为true则不会清空
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("charstream\\b.txt");//相当于new file(des)

        //String str = "走进馆内，一幅幅珍贵的历史图片、一件件斑驳的革命文物、一段段感人的英雄故事";

        fw.close();
    }
}
