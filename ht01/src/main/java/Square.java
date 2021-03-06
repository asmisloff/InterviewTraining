import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Square extends Rectangle {

    private float x0;
    private float y0;
    private float side;

    public Square(float x0, float y0, float side) {
        super(x0, y0, x0 + side, y0 + side);
        this.side = side;
    }

    @Override
    public Shape copyTo(float x, float y) {
        return new Square(x, y, side);
    }

    @Override
    public void setX0(float x) {
        x0 = x;
        x1 = x0 + side;
    }

    @Override
    public void setY0(float y) {
        y0 = y;
        y1 = y0 + side;
    }

    @Override
    public void setX1(float x) {
        x1 = x;
        x0 = x1 - side;
    }

    @Override
    public void setY1(float y) {
        y1 = y;
        y0 = y1 - side;
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
        x1 = x0 + side;
        y1 = y0 + side;
    }
}
