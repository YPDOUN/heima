package Exception.ExceptionDemo7;

public class Person {
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeOutOfRangeException, NameOutOfRangeException {
        if(age < 18 || age > 40){
            throw new AgeOutOfRangeException("Age out of range");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int nLength = name.length();
        if (nLength < 2 || nLength > 10){
            throw new NameOutOfRangeException("Name out of range");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age;
    }
}
