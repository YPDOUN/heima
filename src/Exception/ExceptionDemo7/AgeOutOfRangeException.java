package Exception.ExceptionDemo7;

/*
 * 自定义异常类：
 *  1.写明继承哪个异常类
 *  2.写一个空参构造和一个带参构造
 */
public class AgeOutOfRangeException extends RuntimeException {
    public AgeOutOfRangeException() {
    }

    public AgeOutOfRangeException(String message) {
        super(message);
    }
}
