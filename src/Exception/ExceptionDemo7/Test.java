package Exception.ExceptionDemo7;

import java.util.Scanner;

/*
 * 要求姓名范围在3-10
 *    年龄在18-40
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                person.setName(name);

                System.out.println("Enter age: ");
                String age = sc.nextLine();
                person.setAge(Integer.parseInt(age));
                break;
            } catch (AgeOutOfRangeException e) {
                e.printStackTrace();
            } catch (NameOutOfRangeException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println(person);

    }
}
