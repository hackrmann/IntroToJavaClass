package complexmatrix;


import complexmatrix.exceptions.IncompatibleMatrixException;
import complexmatrix.exceptions.MatrixDimensionException;

import java.io.*;
import java.util.ArrayList;

public class ComplexMatrix {

    public Complex complex[][];

    public Complex[][] getComplex() {
        return complex;
    }

    public int getRows() {
        return m;
    }

    public int getColumns() {
        return n;
    }

    int m, n;

    public ComplexMatrix(int m, int n) {
        this.m = m;
        this.n = n;
        complex = new Complex[m][n];
        for (int i = 0; i < this.m; i++)
            for (int j = 0; j < this.n; j++)
                complex[i][j] = new Complex();
    }

    public ComplexMatrix(Complex[][] input) {
        this.complex = input;
    }

    public ComplexMatrix add(ComplexMatrix cm) throws MatrixDimensionException {
        if (!(this.m == cm.getRows() && this.n == cm.getColumns())) {
            throw new MatrixDimensionException("MatrixDimensionException caught: Dimensions of matrices should be same " + "(" + this.m + ", " + this.n + ") for add operation, is instead of shape (" + cm.getRows() + ", " + cm.getColumns() + ")");
        }

        for (int i = 0; i < this.m; i++)
            for (int j = 0; j < this.n; j++)
                this.complex[i][j] = this.complex[i][j].add(cm.getComplex()[i][j]);
        return this;
    }

    public ComplexMatrix mult(ComplexMatrix cm) throws MatrixDimensionException {
        int cm_rows = cm.getRows(), cm_cols = cm.getColumns();
        if (!(this.n == cm_rows)) {
            throw new MatrixDimensionException("MatrixDimensionException caught: Second matrix should have the same number of rows as the number of columns of first matrix, but instead it has shape (" + cm.getRows() + ", " + cm.getColumns() + ")");
        }
        ComplexMatrix multipliedMatrix = new ComplexMatrix(this.m, cm.getColumns());
        Complex result = new Complex();
        for (int i = 0; i < this.m; i++) {
            result.setRealAndImaginary(0, 0);
            for (int j = 0; j < cm.getColumns(); j++) {
                for (int k = 0; k < cm_rows; k++) {
                    result = result.add(this.complex[i][k].multiply(cm.getComplex()[k][j]));
                }
                multipliedMatrix.complex[i][j].setRealAndImaginary(result.getReal(), result.getImaginary());
            }
        }
        return multipliedMatrix;
    }

    public static ComplexMatrix read(String fileName) throws IncompatibleMatrixException {
        File f = new File(fileName);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String inString = null;
        boolean continueReadingFile = true;
        String[] line;
        int column = 0;
        ArrayList<ArrayList<Complex>> complexNumbers = new ArrayList<>();
        ArrayList<Complex> complexNumberLine = new ArrayList<>();

        try {
            fileReader = new FileReader(f);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException fne) {
            System.err.println("File does not exist!");
            System.exit(1);
        }
        do {
            try {
                inString = bufferedReader.readLine();
                if (continueReadingFile = (inString != null)) {
                    line = inString.strip().split(" ");
                    if (line.length > 0) {
                        for (String number : line) {
                            complexNumberLine.add(new Complex(Double.parseDouble(number.split("_")[0]),
                                    Double.parseDouble(number.split("_")[1])));
                        }
                        complexNumbers.add(complexNumberLine);
                        complexNumberLine = new ArrayList<>();
                        ++column;
                    }
                }
            } catch (IOException ioe) {
                System.out.println("Input error!");
            }
        } while (continueReadingFile);
        int numberOfRows = column, numberOfColumns = complexNumbers.get(0).size();
        ComplexMatrix complexMatrix = new ComplexMatrix(numberOfRows, numberOfColumns);
        for (int i = 0; i < numberOfRows; i++) {
            column = complexNumbers.get(i).size();
            if (column != numberOfColumns)
                throw new IncompatibleMatrixException("IncompatibleMatrixException caught while reading file " + fileName + ": Matrix does not have consistent dimensions. Check row "+(i+1)+" and column "+(column+1));
            for (int j = 0; j < column; j++) {
                complexMatrix.complex[i][j] = complexNumbers.get(i).get(j);
            }
        }
        return complexMatrix;
    }

    public void write(String fileName) {
        File f = new File(fileName);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        String line = "";

        try {
            fileWriter = new FileWriter(f);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (FileNotFoundException fne) {
            System.err.println("File does not exist!");
            System.exit(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                line += this.complex[i][j].getReal()+"_"+this.complex[i][j].getImaginary() + " ";
            }
            line+= "\n";
        }
        try {
            bufferedWriter.write(line);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        String printableMatrix = "[";
        if (this.m > 0 && this.n > 0) {
            for (int i = 0; i < this.m; i++) {
                printableMatrix += "[";
                for (int j = 0; j < this.n - 1; j++) {
                    printableMatrix += this.complex[i][j].toString() + ",\t";
                }
                printableMatrix += this.complex[i][this.n - 1].toString() + "],\n";
            }
            printableMatrix = printableMatrix.substring(0, printableMatrix.length() - 2) + "]";
        } else {
            return "[]";
        }
        return printableMatrix;
    }

    public static void main(String[] args) {
        ComplexMatrix c1 = null, c2 = null, c3 = null, broken_matrix;
        try {
            c1 = ComplexMatrix.read("complexmatrix1.txt");
            System.out.println(c1.toString());
            c2 = ComplexMatrix.read("complexmatrix2.txt");
            c3 = ComplexMatrix.read("complexmatrix3.txt");
            broken_matrix = ComplexMatrix.read("brokenmatrix.txt");
        } catch (IncompatibleMatrixException e) {
            e.toString();
        }
        System.out.println("Multiplying c1 and c2");
        try {
            c1.mult(c2);
        } catch (MatrixDimensionException e) {
            e.toString();
        }
        System.out.println(c1.toString());
        System.out.println("Adding c2 and c3 into c2:");
        try {
            c2.add(c3);
        } catch (MatrixDimensionException mde) {
            mde.toString();
        }
        System.out.println("Writing matrix c1 to file written_output.txt....");
        c1.write("written_output.txt");
    }
}
