package Innerclass1;

/*
 * 成员内部类和局部内部类
 * 一个处于成员变量位置 一个处于局部变量(函数)位置
 */
public class Inner1 {
    int a = 10;
    //成员内部类(此处为私有内部类）
    private class Inner_Class1{
        public void show(){
            System.out.println("Inner_Class1.show()");
        }
    }

    public void showInnerClass(){
        Inner_Class1 i = new Inner_Class1();
        i.show();
    }

    public void method(){
        //局部内部类
        class Inner_Class2{
            void show(){
                System.out.println("Inner_Class2.show()");
            }
        }
        //调用只能先创建
        Inner_Class2 i = new Inner_Class2();
        i.show();
    }
}


