package Inner_Class2;

/*
 * 匿名内部类适用场景
 * 存在用接口或者抽象类作为方法参数时，作为创建接口的临时对象
 * 只想使用一次
 */
public class JumpingTest {
    public static void main(String[] args) {
        JumpingOperater jo1 = new JumpingOperater();
        Cat c1 = new Cat();
        jo1.method(c1);
        //需要写一个实现了接口的类 再创建对象 再传参

        jo1.method(new Jumping() {
            @Override
            public void jump() {
                System.out.println("Dog Jumping");
            }
        });//推荐第一个

        Jumping j1 = new Jumping() {
            @Override
            public void jump() {
                System.out.println("Dog Jumping");
            }
        };
        jo1.method(j1);                                                                                                     
    }
}
