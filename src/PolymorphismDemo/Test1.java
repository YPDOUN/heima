package PolymorphismDemo;

public class Test1 {
    public static void main(String[] args) {
        Person student = new Student();
        student.name = "John";//静态绑定
        System.out.println(student.name);

        //动态绑定只用于在父类声明过的方法的实际版本具体由谁实现 前提父类有这个方法
        //student.show();   除非强转类型
        ((Student) student).show();
    }
}


class Person{
    public String name;
    int age;
}

class Student extends Person{
    public String name;
    String id;

    void show(){
        System.out.println("I am student");
    }

}
