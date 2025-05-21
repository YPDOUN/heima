package myinterface;

/*
 * JDK8后允许在接口中定义默认方法，使用default修饰，为了解决接口升级问题
 * 格式：public default void xx() {}
 * 默认方法不是抽象方法，不被强制重写，如果被重写就要去掉default关键字
 * public可以被省略，default不能被省略
 * 当两个接口有同名默认方法时，必须重写(不重写编译器无法知道是哪个方法)
 *
 * JDK8以后允许接口定义static静态方法  用接口名调用
 *
 * JDK9以后允许接口定义private方法
 *     1.避免default/static方法中的重复代码
 *     2.隐藏实现细节，仅为接口内部工具方法
 * 格式1：private void xx() {} 为默认方法服务
 * 格式2：private static void xx() {} 为静态方法服务
 */
public class Test2 {
    public static void main(String[] args) {
       demo1 d = new demo1();
       d.show();
       d.show2();

       demo2 d2 = new demo2();
       d2.show();
       d2.show2();
    }
}

interface InterA{
    public abstract void show();
    public default void show2(){
        System.out.println("A默认方法");
    }
}

class demo1 implements InterA{
    @Override
    public void show() {
        System.out.println("A实现接口方法");
    }
}
interface InterB{
    public abstract void show();
    public default void show2(){
        System.out.println("B默认方法");
    }
}

class demo2 implements InterA, InterB{

    @Override
    public void show() {
        System.out.println("实现A, B同名接口方法");
    }

    @Override
    public void show2() {
        System.out.println("实现A, B同名默认方法");
    }
}

