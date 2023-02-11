
public class SquarePyramid {
    static private int nextId = 0;
    private int id;
    private double side;
    private double height;

    public SquarePyramid() {

    }

    public SquarePyramid(double side, double height) {
        this.side = side;
        this.height = height;
        id = nextId++;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getID() {
        return id;
    }

    public double getVolume() {
        return side * side * height / 3;
    }

    public double getSurfaceArea() {
        return side * side + 2 * side * Math.sqrt((side * side / 4) + height * height);
    }

    public static void main(String[] args) {
        SquarePyramid squarePyramid1 = new SquarePyramid(4, 5);
        SquarePyramid squarePyramid2 = new SquarePyramid(6.78, 44.1);
        SquarePyramid squarePyramid3 = new SquarePyramid(65, 10);

        System.out.println("Square Pyramid ID:" + squarePyramid1.getID() + " is of " + squarePyramid1.getSurfaceArea() + " surface area");
        System.out.println("Square Pyramid ID:" + squarePyramid2.getID() + " is of " + squarePyramid1.getVolume() + " volume");
        System.out.println("Square Pyramid ID:" + squarePyramid3.getID() + " is of " + squarePyramid3.getSurfaceArea() + " surface area");
    }
}
