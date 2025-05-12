package AbstractClassDemo;

/*
 * 1.抽象类不能实例化，可以有成员变量
 * 2.抽象类可以有构造方法 作用：当子类创建对象时，给属性赋值
 * 3.抽象方法一定是抽象类，但抽象类不一定有抽象方法
 * 4.抽象类的子类必须要重写抽象方法，或者是抽象类
 */
class Test {
    public static void main(String[] args) {
        frog f = new frog("蛙蛙", 5);
        System.out.println(f.action());
        System.out.println(f.drink());

    }
}


abstract class Animal{
    String name;
    int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract String action();
    String drink(){
        return name + "正在喝水";
    }
}

class frog extends Animal{
    public frog() {
    }

    public frog(String name, int age) {
        super(name, age);
    }

    @Override
    String action() {
        return name + "吃虫子";
    }
}

class dog extends Animal{
    public dog() {
    }

    public dog(String name, int age) {
        super(name, age);
    }

    @Override
    String action() {
        return name + "正在吃骨头";
    }
}

class sheep extends Animal{
    public sheep() {
    }

    public sheep(String name, int age) {
        super(name, age);
    }

    @Override
    String action() {
        return name + "正在吃草";
    }
}


