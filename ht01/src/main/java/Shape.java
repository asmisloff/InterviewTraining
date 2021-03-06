public interface Shape {

    double area();
    double perimeter();
    void moveTo(float x, float y);
    Shape copyTo(float x, float y);
    boolean isCongruentTo(Shape other, float accuracy);

}
