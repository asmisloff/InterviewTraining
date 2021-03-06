import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Rectangle implements Shape {

    /* Lower left corner */
    protected float x0;
    protected float y0;

    /* Upper right corner */
    protected float x1;
    protected float y1;

    public Rectangle() {
        x0 = 0; y0 = 0; x1 = 0; y1 = 0;
    }

    public Rectangle(float x0, float y0, float x1, float y1) {
        this.x0 = Math.min(x0, x1);
        this.y0 = Math.min(y0, y1);
        this.x1 = Math.max(x0, x1);
        this.y1 = Math.max(y0, y1);
    }

    public float xSide() {
        return x1 - x0;
    }

    public float ySide() {
        return y1 - y0;
    }

    @Override
    public double area() {
        return xSide() * ySide();
    }

    @Override
    public double perimeter() {
        return 2.0 * (xSide() + ySide());
    }

    @Override
    public void moveTo(float x, float y) {
        x0 += x; y0 += y;
        x1 += x; y1 += y;
    }

    @Override
    public Shape copyTo(float x, float y) {
        return new Rectangle(x0 + x, y0 + y, x1 + x, y1 + y);
    }

    @Override
    public boolean isCongruentTo(Shape other, float accuracy) {

        if (!(other instanceof Rectangle)) {
            return false;
        }

        return Math.abs(x0 - ((Rectangle) other).getX0()) < accuracy
            && Math.abs(y0 - ((Rectangle) other).getY0()) < accuracy
            && Math.abs(x1 - ((Rectangle) other).getX1()) < accuracy
            && Math.abs(y1 - ((Rectangle) other).getY1()) < accuracy;

    }

    public float getX0() {
        return x0;
    }

    public void setX0(float x) {
        if (x > x1) {
            x0 = x1;
            x1 = x;
        } else {
            x0 = x;
        }
    }

    public float getY0() {
        return y0;
    }

    public void setY0(float y) {
        if (y > y1) {
            y0 = y1;
            y1 = y;
        } else {
            y0 = y;
        }
    }

    public float getX1() {
        return x1;
    }

    public void setX1(float x) {
        if (x < x0) {
            x1 = x0;
            x0 = x;
        } else {
            x1 = x;
        }
    }

    public float getY1() {
        return y1;
    }

    public void setY1(float y) {
        if (y < y0) {
            y1 = y0;
            y0 = y;
        } else {
            y1 = y;
        }
    }

}
