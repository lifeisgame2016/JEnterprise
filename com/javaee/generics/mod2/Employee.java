package com.javaee.generics.mod2;

/**
 * Created by Den on 26.08.2016.
 */
public class Employee extends Person {

    private String profession;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Employee(String name, String surname, String profession){
        super(name, surname);
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + super.getName()+ '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
