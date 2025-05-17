package Exception.ExceptionDemo3;

public class Test {
    public static void main(String[] args) {
        //如果try的问题没有与catch相匹配的，会怎样
        try {
            System.out.println(10/0);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组下标异常");
        }catch (ArithmeticException e){
            System.out.println("算数异常");
        }

        try {
            System.out.println(10/0);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组下标异常");
        }
        //结果就是相当于没写，交给JVM处理
    }
}
