package Exception.ExceptionDemo2;

public class Test {
    public static void main(String[] args) {
        //如果try中会遇到多个问题，怎么执行
        int[] a = {1,2,3,4,5};

        try{
            System.out.println(a[10]);
            System.out.println(10 / 0);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界");
        }catch (ArithmeticException e){
            System.out.println("算数异常");
        }

        System.out.println("是否执行");
    }
    //要写多个catch与之匹配， 同时父类要排在最后，例如Exception要往下写
}
