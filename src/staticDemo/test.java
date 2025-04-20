package staticDemo;

/*
 * static变量：
 *          1.所有对象共享这个static变量 类似类的固有属性
 *          2.类加载时初始化，且只存在一份
 *          3.推荐在类外赋值
 *          4.public可以类名直接访问
 * static方法：
 *          1.可以通过类名直接访问
 *          2.不能访问非静态变量或者方法 本质是没有this对象
 */
public class test {
    public static void main(String[] args) {

    }
}
