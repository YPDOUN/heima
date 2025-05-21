package inheritance1;

/*
 * 继承 - 将多个子类的重复代码抽离到父类中，减少代码的冗余，提高复用性
 * java支持多层继承和单继承，不支持多继承 格式：public class child extends father{}
 * Object类是根类
 * 子类只能访问父类的非私有变量
 */
public class test {
    public static void main(String[] args) {
//        Ragdoll ragdoll = new Ragdoll();
//        ragdoll.eat();//间接父类 Animal
//        ragdoll.catchMouse();//父类Cat
//
//        Husky huskie = new Husky();
//        huskie.ruinHouse();

        son s1 = new son();
        //son s2 = new son(18);
    }
}

class father{
    public father() {}; //此处是java虚拟机创建的空参构造
    public father(int age) {
        System.out.println(age);
    };
}

class son extends father{
    //子类无法继承父类的构造函数
}
