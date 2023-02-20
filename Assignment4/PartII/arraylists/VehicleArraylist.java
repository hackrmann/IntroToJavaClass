package arraylists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import vehicles.*;

public class VehicleArraylist {

    public static void main(String[] args) {
        // this ArrayList MUST be parameterized
        ArrayList<Vehicle> vehiclesArrayList = new ArrayList<Vehicle>();

        // this is the variable you should retain to compare
        // to the other objects in the arraylist

        part1(vehiclesArrayList);
        System.out.println("--------------");
        part2(vehiclesArrayList);
        System.out.println("--------------");
        part3(vehiclesArrayList);
        System.out.println("--------------");
        part4(vehiclesArrayList);
        System.out.println("--------------");

    }

    public static void part1(ArrayList<Vehicle> vehiclesArrayList) {
        vehiclesArrayList.add(new Motorcycle(new String[]{"grip warmers", "usb charger"}));
        vehiclesArrayList.add(new Car(20, 4, "blue"));
        vehiclesArrayList.add(new Car(20, 4, "blue"));
        vehiclesArrayList.add(new Bicycle("black"));
        vehiclesArrayList.add(new CargoCycle(3, 10, "green"));
        vehiclesArrayList.add(new CargoCycle(3, 10, "green"));
        vehiclesArrayList.add(new Car(10, 2, "grey"));
        vehiclesArrayList.add(new Car(25, 4, "white"));
    }
    public static void part2(ArrayList<Vehicle> vehiclesArrayList) {
        int sumCargoSpace = 0, noOfCars = 0;
        for (int i = 0; i < vehiclesArrayList.size(); i++) {
            if (vehiclesArrayList.get(i) instanceof Car) {
                sumCargoSpace += vehiclesArrayList.get(i).getCargoSpace();
                ++noOfCars;
            }
        }
        System.out.println("Average cargo space of all cars is: " + (sumCargoSpace / (float) noOfCars));
    }
    public static void part3(ArrayList<Vehicle> vehiclesArrayList) {
        Car blueCar;
        for (int i = 0; i < vehiclesArrayList.size(); i++) {
            if (vehiclesArrayList.get(i) instanceof Car) {
                blueCar = (Car) vehiclesArrayList.get(i);
                for (int j = vehiclesArrayList.size() - 1; j > i; j--) {
                    if(blueCar.equals(vehiclesArrayList.get(j))) {
                        System.out.println("Same object alert!");
                        System.out.println(vehiclesArrayList.get(j).toString());
                        vehiclesArrayList.remove(j);
                    }
                }
            }
        }
    }
    public static void part4(ArrayList<Vehicle> vehiclesArrayList) {
        for (int i = 0; i < vehiclesArrayList.size(); i++)
            System.out.println(vehiclesArrayList.get(i).toString());
    }

}
