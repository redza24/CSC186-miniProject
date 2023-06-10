public class Person {
    private String name;
    private int age;
    private char gender;

    //default constructor
    public Person() {
        name = "";
        age = 0;
        gender = ' ';
    }

    //normal constructor
    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

}
