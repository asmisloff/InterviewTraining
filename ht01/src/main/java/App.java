import java.util.List;

public class App {

    public static void main(String[] args) {
        testPerson();
        System.out.println();
        testShapes();
    }

    private static void testPerson() {
        System.out.println("----- Test Person -----");

        Person johnSmith = Person.createInstance()
                .withFirstName("John")
                .withLastName("Smith")
                .withAge(100)
                .withGender("Male")
                .withPhone("2-12-85-06");
        System.out.println(johnSmith);
    }

    private static void testShapes() {
        System.out.println("----- Test Shapes -----");

        Shape circle = new Circle(0, 0, 10);
        System.out.println(circle);
        circle.moveTo(10, 20);
        System.out.println(circle);

        Rectangle rect = new Rectangle(0,0,10,25);
        System.out.println(rect);
        Square square = new Square(0,0,20);
        System.out.println(square);
        System.out.println(rect.isCongruentTo(square, 0.01f));
        rect.setX1(25);
        System.out.println(rect);
        square.setSide(25);
        System.out.println(square);
        System.out.println(rect.isCongruentTo(square, 0.01f));

        List<Shape> shapes = List.of(circle, rect, square);
        System.out.println(shapes);
    }

}
