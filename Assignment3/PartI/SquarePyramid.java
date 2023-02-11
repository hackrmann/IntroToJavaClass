
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
        return side*side*height/3;
    }

    public double getSurfaceArea() {
        return side*side + 2*side*Math.sqrt((side*side/4)+height*height);
    }
}
