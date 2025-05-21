package exception.exceptiondemo5;

public class Test {
    public static void main(String[] args) {
        /*
         *  public String toString();
         *  public String getMessage();
         *  public void printStackTrace();
         */

        try {
            System.out.println(10/0);
        } catch (ArithmeticException e) {
            e.printStackTrace();//打印红色语句但不停止JVM
        }

        System.out.println("执行？");
    }
}
