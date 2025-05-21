package arraylist;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //1.ArrayList的创建
        ArrayList<String> list = new ArrayList<>();//默认初始容量为10
        /*
        ArrayList<String> list = new ArrayList<>(100); 指定初始容量为100
         */

        //基础语法-增删查改
        //basic_gram1(list);

        //循环
        basic_gram2(list);
    }

    public static void basic_gram1(ArrayList<String> list){
        //2.添加元素
        list.add("Apple");
        list.add("Banana");
        System.out.println(list);//打印元素
        //2.指定索引插入
        list.add(1,"Orange");
        System.out.println(list);

        //2.获取元素
        String name = list.get(1);
        System.out.println("get(1): " + name);

        //2.修改元素
        list.set(1,"Blackberry");
        System.out.println(list);

        //2.删除元素
        list.remove(1);//序号删除
        System.out.println(list);
        list.remove("Apple");//值删除
        System.out.println(list);

        //2.查找元素
        boolean b = list.contains("Apple");
        int index = list.indexOf("Apple");
        System.out.println(b + " " + "index: " + index);
    }

    public static void basic_gram2(ArrayList<String> list){
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //增强for循环
        for(String s : list){
            System.out.print(s + " ");
        }
        System.out.println();

        //foreach循环
        list.forEach(item -> System.out.print(item + " "));
    }
}
