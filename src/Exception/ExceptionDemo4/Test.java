package exception.exceptiondemo4;

public class Test {
    public static void main(String[] args) {
        //try中出现了问题，后面会执行吗

        try{
            System.out.println(10/0);
            System.out.println("下一句");
        }catch (ArithmeticException e){
            System.out.println("算数异常");
        }
        //结果：当出现问题直接跳转到创建对应的异常对象，不会执行下面的代码
    }
}
