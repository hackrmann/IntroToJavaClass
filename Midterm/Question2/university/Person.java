package university;

import java.util.ArrayList;

public abstract class Person {

	private static int id = 0;
	private int unique_id;

	private int age;

	public Person(int age) {
		unique_id = ++id;
		this.age = age;
	}
	public String toString() {
		String s = String.format("ID: %d\nAge: %d\n", this.unique_id, this.age);
		return s;
	}
	public static void printPersons(ArrayList<Person> persons) {
		for(Person person: persons) {
			System.out.println(person.toString());
		}
	}

	public boolean equals(Object obj) {
		if(this.age == ((Person)obj).age)
			return true;
		return false;
	}
}
