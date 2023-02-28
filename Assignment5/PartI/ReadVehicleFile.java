import java.io.*;
import java.util.ArrayList;

import vehicles.*;
import vehicles.exceptions.VehicleException;

/* your tasks:
 * create a class called VehicleException
 * createVehicle should throw a VehicleException
 * in main(), you should catch the VehicleException
 *
 */
public class ReadVehicleFile {

    public static Vehicle createVehicle(String vehicleName) throws VehicleException {

        /* if vehicleName is "Motorcycle" return Motorcycle();
         * if vehicleName is "Car" return Car();
         * if vehicleName is "Bicycle" return Bicycle();
         * if vehicleName is "CargoCycle" return CargoCycle();
         * if it is not any one of these, it should throw
         * a VehicleException
         */
        switch (vehicleName) {
            case "Motorcycle":
                return new Motorcycle();
            case "Car":
                return new Car();
            case "Bicycle":
                return new Bicycle();
            case "CargoBike":
                return new CargoCycle();
            default:
                throw new VehicleException(vehicleName + " is not recognized as a vehicle");
        }
    }

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
        File f = new File("vehicles.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String inString = null;
        boolean continueReadingFile = true;

        try {
            fileReader = new FileReader(f);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException fne) {
            System.err.println("File does not exist!");
            System.exit(1);
        }

        /* create a loop to read the file line-by-line */

        do {
            try {
                inString = bufferedReader.readLine();
                if(continueReadingFile = (inString != null)) {
                    Vehicle vehicle = createVehicle(inString);
                    vehicleList.add(vehicle);
                }
            } catch (VehicleException ve) {
                System.err.println("Cannot create Vehicle: " + ve.errorMessage());
            } catch (IOException ioe) {
                System.out.println("Input error!");
            }
        } while (continueReadingFile);

        System.out.println(vehicleList);
        System.out.println("-----\nNumber of vehicles is: "+vehicleList.size());

    }
}
