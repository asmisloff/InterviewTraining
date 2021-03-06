import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Circle implements Shape {

    private float x0;
    private float y0;
    private float radius;

    public Circle(float x0, float y0, float radius) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2.0 * Math.PI * radius;
    }

    @Override
    public void moveTo(float x, float y) {
        x0 = x; y0 = y;
    }

    @Override
    public Shape copyTo(float x, float y) {
        return new Circle(x0, y0, radius);
    }

    @Override
    public boolean isCongruentTo(Shape other, float accuracy) {

        if (!(other instanceof Circle)) {
            return false;
        }

        return Math.abs(radius - ((Circle) other).radius) < accuracy;

    }

}
