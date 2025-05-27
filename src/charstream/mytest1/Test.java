package charstream.mytest1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src\\charstream\\mytest1.txt");
        FileWriter fw = new FileWriter("src\\charstream\\mytest2.txt");

        //从文件获取9-1-1-1-9的格式
        int len;
        StringBuilder sb = new StringBuilder();
        while((len = fr.read()) != -1){
            sb.append((char)len);
        }
        String str = sb.toString();
        String[] s = str.split("-");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            int n = Integer.parseInt(s[i]);
            list.add(n);
        }

        Collections.sort(list);

        //写入排好序的结果
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                fw.write(list.get(i) + "");
                fw.write("-");
            }else {
                fw.write(list.get(i) + "");
            }
        }

        fw.close();
        fr.close();
    }
}
