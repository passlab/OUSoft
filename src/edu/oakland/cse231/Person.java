package edu.oakland.cse231;

/**
 * Created by yy8 on 2/2/17.
 */
public class Person {
    String firstName;
    String lastName;
    int id;

    public Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName;
    }
}
