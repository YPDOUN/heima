package ManagerSystemDeom;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void start() {
        ArrayList<Student> students = new ArrayList<>();

        while(true){
            show();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter input: ");
            String input = sc.next();

            switch(input){
                case "1" -> addStudent(students);
                case "2" -> deleteStudent(students);
                case "3" -> updateStudent(students);
                case "4" -> findStudent(students);
                case "5" -> {
                    System.out.println("exit!");
                    System.exit(0);
                }
                default -> System.out.println("wrong input! Please try again!");
            }
        }
    }

    public static void show(){
        System.out.println("==============学生管理系统==============");
        System.out.println("==============1. 添加学生==============");
        System.out.println("==============2. 删除学生==============");
        System.out.println("==============3. 修改学生==============");
        System.out.println("==============4. 查询学生==============");
        System.out.println("==============5. 退出系统==============");
        System.out.println("=====================================");
    }

    //添加学生
    public static void addStudent(ArrayList<Student> students){
        Scanner sc = new Scanner(System.in);
        String id, name, address;
        int age;

        while(true){
            System.out.println("Please enter id:");
            id = sc.next();
            if(contains(students, id)){
                System.out.println(id + " already exist!");
            }else
                break;
        }

        System.out.println("Please enter name:");
        name = sc.next();

        System.out.println("Please enter age:");
        age = sc.nextInt();

        System.out.println("Please enter address:");
        address = sc.next();

        Student s = new Student(id, name, age, address);

        students.add(s);
        System.out.println("add success!");
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> students){
        //获取待删除元素的索引
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter id:");
        String id = sc.next();

        int index = getIndex(students, id);
        if(index == -1){
            System.out.println(id + " does not exist!");
        }else{
            students.remove(index);
            System.out.println(id +     "delete success!");
        }
    }

    //修改学生
    public static void updateStudent(ArrayList<Student> students){
        System.out.println("Please enter id:");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();

        //判断id是否存在
        int index = getIndex(students, id);
        if(index == -1){
            System.out.println(id + " does not exist!");
            return;
        }else{
            Student s = students.get(index);
            System.out.println("Please enter name:");
            String newname = sc.next();
            s.setName(newname);

            System.out.println("Please enter age:");
            int newage = sc.nextInt();
            s.setAge(newage);

            System.out.println("Please enter address:");
            String newaddress = sc.next();
            s.setAddress(newaddress);

            System.out.println("update success!");
        }
    }

    //查找学生
    public static void findStudent(ArrayList<Student> students){
        if(students.isEmpty()){
            System.out.println("暂无学生信息，请输入！");
            return;
        }

        System.out.println("id\t\t姓名\t年龄\t家庭住址");
        for(Student student : students){
            System.out.println(student.getId() + "\t\t" + student.getName() + "\t" + student.getAge() + "\t" +  student.getAddress());
        }
    }

    //检测动态数组中是否有重复的id值
    public static boolean contains(ArrayList<Student> students, String id){
        //循环遍历每一个学生对象
        /*for(Student s : students){
            //id存在返回true 否则返回false
            if(s.getId().equals(id))
                return true;
        }
        return false;*/

        //使用下面的getIndex删除重复代码, >-1代表此数组中已经有了这个id
        return getIndex(students, id) >= 0;
    }

    //获取待删除元素的下标
    public static int getIndex(ArrayList<Student> students, String id){
        //遍历查找id
        for(int i = 0; i < students.size(); i++){
            //动态数组中取出student对象获取到id进行字符串比较
            if(students.get(i).getId().equals(id))
                return i;
        }

        //查无此id返回-1
        return -1;
    }
}
