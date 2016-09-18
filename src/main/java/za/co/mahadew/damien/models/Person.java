package za.co.mahadew.damien.models;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
public class Person {

    private String name;
    private Integer age;
    private Laptop laptop;

    public Person(String aName, Integer aAge) {
        name = aName;
        age = aAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
