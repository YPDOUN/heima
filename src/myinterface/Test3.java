package myinterface;

//接口的多态
interface USB{
    void connect();
}

class Mouse implements USB{
    @Override
    public void connect() {
        System.out.println("鼠标已经连接");
    }
}

class Keyboard implements USB{
    @Override
    public void connect() {
        System.out.println("键盘已经连接");
    }
}
public class Test3 {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        Keyboard keyboard = new Keyboard();

        show(mouse);
        show(keyboard);
    }

    private static void show(USB u) {
        u.connect();
    }
}
