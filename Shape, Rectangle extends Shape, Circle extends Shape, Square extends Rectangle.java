public static void main(String[] args) {
    try {

        Rectangle rectangle = new Rectangle(5.0, 4.0, "red", true);
        Circle circle = new Circle(3.0, "blue", false);
        Square square = new Square(6.0, "green", true);


        square.setLength(-2.0); // This may throw an IllegalArgumentException
    } catch (IllegalArgumentException e) {
        System.out.println("An IllegalArgumentException occurred: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("An unexpected exception occurred: " + e.getMessage());
    }
}
}

class Shape {
    private String color;
    private boolean filled;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }


}

class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

}

class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }


}

class Square extends Rectangle {
    private double side;

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled); // Since Square is a subclass of Rectangle, we set both width and length to side
        this.side = side;
    }


    @Override
    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        super.setLength(length);
        this.side = length;
    }
}