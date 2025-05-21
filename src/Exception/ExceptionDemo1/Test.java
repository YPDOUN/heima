package exception.exceptiondemo1;

public class Test {
    public static void main(String[] args) {
        //1.如果try中没有遇到问题会怎么走
        int[] arr = {1, 2, 3};

        try {
            System.out.println(arr[10]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界");
        }

        System.out.println("是否执行");

        try {
            System.out.println(arr[1]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界");
        }

        System.out.println("是否执行");

        //会直接打印try里面的正确内容 并向下执行
    }
}
