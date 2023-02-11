
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
        if (!dog1.owner.equals(dog2.owner)) return false;
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

    }
}