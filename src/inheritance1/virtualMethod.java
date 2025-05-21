package inheritance1;

/*
 * 虚方法：虚方法是指在父类中定义的，可以被子类重写（Override）的方法
 *        特性就是能被重写
 * 虚方法表：每个类都维护一张表，表中记录了子类和父类的虚方法地址，
 *         当子类重写父类函数，原本指向父类虚方法的被更新为重写的这个
 */
class animal{
    public void sound(){
        System.out.println("动物叫");
    }
}
class dog extends animal{
    @Override
    public void sound(){
        System.out.println("汪汪汪");
    }
}
public class virtualMethod {
    public static void main(String[] args) {
        animal a = new dog();
        a.sound();
    }
}
