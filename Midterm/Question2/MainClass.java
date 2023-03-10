import university.*;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Affiliate(20));
        people.add(new Faculty(55, 20, true, "Something"));
        people.add(new GraduateStudent(4, "sciences", false));
        people.add(new Undergraduate(20, "Computer Science", true));
        people.add(new Staff(44, 20000));
        people.add(new Staff(44, 20000));

        Person.printPersons(people);
        System.out.println(people.get(5).equals(people.get(4)));
    }
}
