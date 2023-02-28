import java.io.*;
import java.util.List;
import java.util.ArrayList;

import vehicles.*;

public class ListOfNumbers {

    private ArrayList<RDFTriple<Integer, Integer, Integer>> rdfTripleList;
    private String fileName;

    public ListOfNumbers() {
        // create an ArrayList of Pairs of Integers
        rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    }

    public ArrayList getRdfTripleList() {
        return this.rdfTripleList;
    }

    public void createList() {
        for (int i = 0; i < 100; i++) {
            Integer number1 = (int) (Math.random() * 10000);
            Integer number2 = (int) (Math.random() * 10000);
            Integer number3 = (int) (Math.random() * 10000);
            // fill the existing list with RDFTriple objects
            // of three numbers.
            RDFTriple<Integer, Integer, Integer> rdfTriple = new RDFTriple<>(number1, number2, number3);
            rdfTripleList.add(rdfTriple);
        }
    }


    public ListOfNumbers(String fileName) {
        this();
        this.fileName = fileName;
    }

    public void readList() {
        rdfTripleList = new ArrayList<>();
        RDFTriple<Integer, Integer, Integer> rdfTriple = new RDFTriple<>(0, 0, 0);
        String line = null;
        String[] numbers = new String[3];
        boolean continueReading = true;
        File f = new File(this.fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            while (continueReading) {
                try {
                    line = bufferedReader.readLine();
                    continueReading = (line != null);
                    if (continueReading) {
                        numbers = line.split(" ");
                        rdfTriple.setSubj(Integer.parseInt(numbers[0]));
                        rdfTriple.setPred(Integer.parseInt(numbers[1]));
                        rdfTriple.setObj(Integer.parseInt(numbers[2]));
                        rdfTripleList.add(rdfTriple);
                    }

                } catch (IOException ioe) {
                    System.err.println("There was an I/O error while reading the line! Exiting");
                }
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File " + fileName + " not found! Exiting");
            System.exit(1);
        }
    }

    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter(this.fileName));
            for (int i = 0; i < rdfTripleList.size(); i++)
                out.println(rdfTripleList.get(i).getSubj() + " "
                        + rdfTripleList.get(i).getPred() + " " + rdfTripleList.get(i).getObj());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }

    public static void cat(String fileName) throws IOException {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (IOException ioException) {

        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public static void main(String[] args) {
        ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
        try {
            listOfNumbers.createList();                     //Generate new random numbers and populate list
            listOfNumbers.writeList();                      //Write the generated random list of numbers in the given filename
            ListOfNumbers.cat("numberfile.txt");   //Read the written file and print all contents in the console
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        listOfNumbers.readList();
    }

}
