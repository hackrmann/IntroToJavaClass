
public class Dog {
    private int age;
    private String owner;
    private String breed;

    public Dog(int age, String owner, String breed) {
        this.age = age;
        this.owner = owner;
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public static boolean hasSameOwner(Dog dog1, Dog dog2) {
        if (!dog1.owner.toUpperCase().equals(dog2.owner.toUpperCase())) return false;
        return true;
    }

    public static double avgAge(Dog[] dogs) {
        int n = dogs.length, sum = 0;
        for (Dog dog : dogs)
            sum += dog.age;
        return sum / (double) n;
    }

    public String toString() {
        return breed + ": " + "Owner: " + owner + ", Age: " + age;
    }

    public static void main(String[] args) {

        Dog[] dogs = new Dog[5];
        dogs[0] = new Dog(4, "Stephen Colbert", "Boxer");
        dogs[1] = new Dog(8, "Dexter Morgan", "Corgi");
        dogs[2] = new Dog(2, "John Wick", "Dead");
        dogs[3] = new Dog(46, "Cat", "Dachshund");
        dogs[4] = new Dog(11, "Stephen Colbert", "German Shepherd");

        for (Dog dog:dogs) {
            System.out.println(dog.toString());
        }
        System.out.println();
        System.out.println("Average age of dogs: "+Dog.avgAge(dogs)+" years");
        System.out.println(dogs[0].getBreed()+" and "+dogs[4].getBreed()+" have the same owner: "+Dog.hasSameOwner(dogs[0], dogs[4]));
        System.out.println(dogs[1].getBreed()+" and "+dogs[3].getBreed()+" have the same owner: "+Dog.hasSameOwner(dogs[1], dogs[3]));

        dogs[0].setAge(22);
        dogs[0].setBreed("Pomeranian");
        dogs[0].setOwner("Somebody");
        System.out.println(dogs[0].toString());
    }

}