package inheritance2;

public class Person {
    String name;
    int age;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class Student extends Person {
    //当父类只有 有参构造函数时 子类必须为其初始化
    public Student(int age, String name) {
        super(age, name);
    }
}