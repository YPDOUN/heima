package Innerclass1;
/* 匿名内部类
 * 前提：存在接口或者类
 * 格式： new class或interface(){
 *       };
 * 本质为一个继承该类或者接口的子类匿名对象
 */
public class Inner2 {

    public void show(){
        /*以下相当于只是一个对象 要调用则用到.
        new Inner2_Demo(){
            @Override
            public void show(){
                System.out.println("匿名内部类");
            }
        };*/

        new Inner2_Demo(){
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        }.show();//调用方法

        //有继承关系就可以运用多态 赋值给父类Inner2_Demo
        Inner2_Demo i = new Inner2_Demo(){
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        };

        i.show();

        Object o1 = new Inner1(){
            //赋给父类object
        };
    }
}
