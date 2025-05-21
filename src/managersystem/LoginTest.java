package managersystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LoginTest {
    private static final String REGISTER = "1";
    private static final String LOGIN = "2";
    private static final String FORGET_PASSWORD = "3";
    private static final String EXIT = "4";

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        User u = new User("lihua1", "1234", "123456789012345678", "12345678901");
        users.add(u);

        while(true){
            System.out.println("1.register");
            System.out.println("2.login");
            System.out.println("3.forgetpassword");
            System.out.println("4.exit");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            String input = sc.next();
            switch(input){
                case REGISTER -> register(users);
                case LOGIN -> login(users);
                case FORGET_PASSWORD -> forgetPassword(users);
                case EXIT -> {
                    System.out.println("退出");
                    System.exit(0);
                }
                default -> System.out.println("无此选项！");
            }
        }
    }

    /*
     * 1.录入用户名，不存在直接退出
     * 2.录入身份证号和手机号
     * 3.判断是否一致，一致则提供修改密码
     */
    private static void forgetPassword(ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入您的用户名：");
        String name = sc.next();

        int index = getIndex(users, name);
        if(index == -1){
            System.out.println("用户" + name + "还不存在，请先注册！");
            return;
        }

        //用户名存在，判断身份证和手机号是否一致
        System.out.println("请输入您账户的身份证：");
        String id = sc.next();
        System.out.println("请输入您账户的手机号：");
        String phoneNumber = sc.next();

        User currentUser = users.get(index);
        if(currentUser.getId().equals(id) && currentUser.getPhonenumber().equals(phoneNumber)){
            String newPassword = validPassword(sc);
            currentUser.setPassword(newPassword);
        } else {
            System.out.println("身份证号或者手机号与当前账号不一致！");
        }
    }

    /*
     * 1.录入用户名
     * 2.录入密码
     * 3.录入验证码
     * - 用户名不存在直接退出，判断验证码是否正确，再判断用户名和密码是否正确
     */
    private static void login(ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String name = sc.next();

        int userIndex = getIndex(users, name);
        if (userIndex == -1) {
            System.out.println("用户" + name + "还不存在，请先注册后再登录！");
            return;
        }

        //以下为用户已存在，先进行验证码验证
        while (true){
            String verifyCode = getCode();
            System.out.println("请输入验证码，当前验证码为：" + verifyCode);
            String enterCode = sc.next();

            //验证码错误，跳过本次循环
            if (enterCode.equalsIgnoreCase(verifyCode)) {
                System.out.println("验证码正确！");
                break;
            } else {
                System.out.println("验证码错误！");
            }
        }

        //验证码正确，开始判断用户名和密码是否一致
        System.out.println("请输入密码");
        String enterPassword = sc.next();
        User currentUser = users.get(userIndex);
        if(currentUser.getPassword().equals(enterPassword)){
            System.out.println("登陆成功！");
            System.out.println("欢迎使用学生管理系统！");
            StudentSystem studentSystem = new StudentSystem();
            studentSystem.start();
        } else {
            System.out.println("用户名或者密码错误！");
        }
    }

    private static String getCode() {
        ArrayList<Character> code = new ArrayList<>();
        for(int i = 0;  i < 26; i++){
            code.add((char)('a' + i));
            code.add((char)('A' + i));
        }

        //用StringBuilder将4个随机字母拼在一起
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for(int i = 0; i < 4; i++){
            int randomIndex = r.nextInt(code.size());
            sb.append(code.get(randomIndex));
        }

        //插入一个随机数
        int randomNum = r.nextInt(10);//0-9
        sb.append(randomNum);

        //String无法直接交换字符因此要转为char数组
        //获取一个随机索引 交换数字位置
        char[] arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(arr.length);

        char tempChar = arr[randomIndex];
        arr[randomIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = tempChar;

        return new String(arr);
    }

    private static void register(ArrayList<User> users){
        System.out.println("注册");
        Scanner sc = new Scanner(System.in);
        
        String username = validUsername(users, sc);
        String password = validPassword(sc);
        String userid = validId(sc);
        String userPhoneNumber = validPhoneNumber(sc);

        User newuser = new User(username, password, userid, userPhoneNumber);
        users.add(newuser);
        System.out.println("注册成功！");

        displayUser(users);
    }

    private static void displayUser(ArrayList<User> users) {
        for (int i = 0; i < users.size(); i++) {
            User tempUser = users.get(i);
            System.out.println("管理员名字：" + tempUser.getName());
            System.out.println("管理员密码：" + tempUser.getPassword());
            System.out.println("身份证号码：" + tempUser.getId());
            System.out.println("手机号码：" + tempUser.getPhonenumber());
        }
    }

    private static String validPhoneNumber(Scanner sc) {
        //手机号长度为11为，不能以0开头，并且不能有字母
        while(true){
            System.out.println("请输入手机号");
            String phoneNumber = sc.next();

            boolean flag = validNumber(phoneNumber);
            //手机号校验通过
            if(flag){
                System.out.println("手机号输入成功！");
                return phoneNumber;
            } else {
                System.out.println("无效手机号！");
            }

        }
    }

    private static boolean validNumber(String phoneNumber) {
        if(phoneNumber.length() != 11 || phoneNumber.charAt(0) == '0')
            return false;

        for (int i = 0; i < phoneNumber.length(); i++) {
            if(phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9')
                return false;
        }

        //到这里代表电话号码是正确的
        return true;
    }

    //身份证校验
    private static String validId(Scanner sc) {
        /*
         * 身份证号码必须为18位
         * 首位不能为0，前17为数字，最后一位可以为X或者x
         */
        while(true){
            System.out.println("请输入您的身份证号码：");
            String id = sc.next();

            if(id.length() != 18 || id.charAt(0) == '0'){
                System.out.println("您输入的身份证号码格式有误！");
                continue;
            }

            if(checkUserid(id)){
                System.out.println("身份证输入成功！");
                return id;
            } else {
                System.out.println("您输入的身份证号码格式有误！");
            }

        }
    }

    private static boolean checkUserid(String id) {
        for(int i = 0; i < id.length() - 1; i++){
            if(id.charAt(i) < '0' || id.charAt(i) > '9'){
                return false;
            }
        }
        char endId = id.charAt(17);
        if(!(endId == 'x' || endId == 'X' || (endId >= '0' && endId <= '9')))
            return false;

        return true;
    }

    private static String validPassword(Scanner sc) {
        while(true){
            System.out.println("请输入密码：");
            String password = sc.next();

            System.out.println("请确认您的密码：");
            String confirmPassword = sc.next();

            if(password.equals(confirmPassword)){
                System.out.println("密码设置成功！");
                return password;
            } else {
                System.out.println("两次密码不一致！");
            }
        }
    }

    private static String validUsername(ArrayList<User> users, Scanner sc) {
        /*
         * 开发流程：
         * 1. 先校验格式（用户名长度3-15位，且是字母+数字的组合）
         * 2. 校验用户名唯一性
         */
        while(true){
            System.out.println("请输入用户名：");
            String username = sc.next();

            //校验格式
            if(!checkUsername(username)){
                System.out.println("用户名不符合规则！");
                continue;
            }

            //校验唯一性
            if(getIndex(users,username) >= 0){
                System.out.println("用户名已经存在！");
                continue;
            }

            System.out.println("用户名符合规则！");
            return username;
            /*   旧版
            boolean flag = checkUsername(username);

            if (flag) {
                int index = getIndex(users, username);
                if (index < 0) {
                    System.out.println("用户创建成功！");
                    newUser.setName(username);
                    break;
                } else {
                    System.out.println("当前用户已存在！");
                }
            } else {
                System.out.println("用户名不符合规则");
            }
             */
        }
    }

    private static boolean checkUsername(String username) {
        //判断用户名长度在3-15位之间,  先用变量存储长度防止调用两次函数降低效率
        int length = username.length();
        if(length < 3 || length > 15)
            return false;

        //以下判断用户名是否为字母和数字的组合
        boolean hasLetter = false, hasDigit = false;

        for(int i = 0; i < length; i++){
            char ch = username.charAt(i);
            if (ch >= '0' && ch <= '9') {
                hasLetter = true;
            } else if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                hasDigit = true;
            } else {
                return false;
            }
        }
        return hasLetter && hasDigit;
    }


    private static int getIndex(ArrayList<User> users, String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(username))
                return i;
        }
        return -1;
    }
}
