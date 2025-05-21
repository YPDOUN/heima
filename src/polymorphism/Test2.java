package polymorphism;

/*
 * final 方法：最终方法，不能被重写
 *           通常用于规则，不希望别人改变
 *       类：最终类，不能被继承
 *       变量：常量，只能被赋值一次
 */
public class Test2 {
    public static void main(String[] args) {
        final int a = 10;
        //a = 10;  不能被修改
        final mytest t = new mytest();
        //引用数据类型不能改变地址值
        t.setAge(10);
        System.out.println(t.getAge());


    }
}

class mytest {
    int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}