package myinterface;

/*
 * 接口：将多个类共有的行为能力抽离出来，减少重复、解耦拓展、统一调用 是一种规则
 *      不可以实例化
 *      不可以有成员变量，能够实现多继承
 *      接口的成员变量：只能为常量 默认修饰为 public static xx
 *      接口的成员方法：JDK7前只能定义抽象方法 默认修饰为 public abstract xx()
 * 类与类：继承关系，只能单继承和多层继承，不能多继承
 * 类与接口：实现关系，可以单实现，也能多实现，也能继承一个类的同时实现多个接口(两个接口有相同方法，只用重写一个，并对这两个方法都生效)
 * 接口与接口：继承关系，可以单继承，也能多继承
 */
class Test {
    public static void main(String[] args) {
        Frog f = new Frog("蛙蛙", 5);
        Dog d = new Dog("小白", 4);
        rabbit r = new rabbit("小红",3);

        System.out.println(f.swimming());
        System.out.println(f.eating());

        System.out.println(d.swimming());
        System.out.println(d.eating());

        System.out.println(r.eating());
    }
}

abstract class Animal{
    String name;
    int age;

    abstract String eating();

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface behaviour{
    String swimming();
}

class Frog extends Animal implements behaviour{
    public Frog(String name, int age) {
        super(name, age);
    }

    public Frog() {
    }

    @Override
    String eating() {
        return name + "正在吃虫子";
    }

    @Override
    public String swimming() {
        return name + "会蛙泳";
    }
}

class Dog extends Animal implements behaviour{
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String swimming() {
        return name + "会狗刨";
    }

    @Override
    String eating() {
        return name + "正在吃骨头";
    }
}

class rabbit extends Animal{
    public rabbit() {
    }

    public rabbit(String name, int age) {
        super(name, age);
    }

    @Override
    String eating() {
        return name + "正在吃胡萝卜";
    }
}