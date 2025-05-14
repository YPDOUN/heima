package UtilDeom.Demo1;

public class Test {
    public static void main(String[] args) {
        Integer i = 100;//自动装箱
        Integer j = Integer.valueOf(200);

        System.out.println("i = " + i + ", j = " + j);

        i += 200;//自动拆箱转换为对应基本数据类型

        Integer k = null;  //当使用对象时应该先判断是否为null
        if(k != null){
            k += 200;
        }
    }
}
