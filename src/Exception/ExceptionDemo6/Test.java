package exception.exceptiondemo6;

/*
 * throws告诉调用者可能会出现哪些异常 运行时异常可以不写，编译时需要写
 * throw 用于方法体中 创建一个异常对象并抛出对象给调用者，结束执行后面的代码
 *
 * 可能为throw抛出 catch接收
 */
public class Test {
    public static void main(String[] args) {
        int[] a = null;

        try {
            getMax(a);
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组长度异常");
        }

        System.out.println("执行？");
    }

    public static int getMax(int[] a) throws NullPointerException, ArithmeticException { //运行时异常可以不写
        if(a == null){
            throw new NullPointerException();
        }
        if(a.length == 0){
            throw new ArrayIndexOutOfBoundsException();
        }

        int max = a[0];
        for (int i = 1; i < a.length; i++){
            if (a[i] > max){
                max = a[i];
            }
        }

        return max;
    }
}
